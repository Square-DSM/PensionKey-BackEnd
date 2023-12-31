package com.example.pensionkeybackend.global.security.jwt

import com.example.pensionkeybackend.domain.user.domain.RefreshToken
import com.example.pensionkeybackend.domain.user.domain.repository.RefreshTokenRepository
import com.example.pensionkeybackend.domain.user.presentation.dto.TokenResponse
import com.example.pensionkeybackend.global.exception.ExpiredTokenException
import com.example.pensionkeybackend.global.exception.InternalServerErrorException
import com.example.pensionkeybackend.global.exception.InvalidTokenException
import com.example.pensionkeybackend.global.security.auth.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.lang.Exception
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class TokenProvider(
    private val tokenProperties: TokenProperties,
    private val authDetailsService: AuthDetailsService,
    private val refreshTokenRepository: RefreshTokenRepository
) {
    fun getToken(accountId: String): TokenResponse {
        val accessToken: String = generateToken(accountId, tokenProperties.accessExp)
        val refreshToken: String = generateRefreshToken(accountId)

        return TokenResponse(accessToken = accessToken, refreshToken = refreshToken)
    }

    fun generateRefreshToken(accountId: String): String {
        val newRefreshToken: String = generateToken(accountId, tokenProperties.refreshExp)
        refreshTokenRepository.save(
            RefreshToken(
                accountId = (accountId),
                token = newRefreshToken
            )
        )
        return newRefreshToken
    }

    private fun generateToken(accountId: String, expiration: Long): String {
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, tokenProperties.secret)
            .setSubject(accountId)
            .setHeaderParam("typ", "access")
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expiration * 1000))
            .compact()
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearer: String? = request.getHeader("Authorization")

        return parseToken(bearer)
    }

    fun parseToken(bearerToken: String?): String? {
        return if (bearerToken != null && bearerToken.startsWith("Bearer")) {
            return bearerToken.replace("Bearer", "")
        } else null
    }

    fun authorization(token: String): UsernamePasswordAuthenticationToken? {
        return token?.let {
            val userDetails: UserDetails = authDetailsService.loadUserByUsername(getTokenSubject(token))
            return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
        }
    }

    private fun getTokenSubject(subject: String): String {
        return getTokenBody(subject).subject
    }

    private fun getTokenBody(token: String?): Claims {
        return try {
            Jwts.parser().setSigningKey(tokenProperties.secret)
                .parseClaimsJws(token).body
        } catch (e: Exception) {
            when (e) {
                is ExpiredJwtException -> throw ExpiredTokenException
                is InvalidClaimException -> throw InvalidTokenException
                else -> throw InternalServerErrorException
            }
        }
    }
}