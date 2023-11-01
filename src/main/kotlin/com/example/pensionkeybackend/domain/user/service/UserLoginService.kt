package com.example.pensionkeybackend.domain.user.service

import com.example.pensionkeybackend.domain.user.exception.PasswordMismatchedException
import com.example.pensionkeybackend.domain.user.facade.UserFacade
import com.example.pensionkeybackend.domain.user.presentation.dto.TokenResponse
import com.example.pensionkeybackend.domain.user.presentation.dto.UserLoginRequest
import com.example.pensionkeybackend.global.security.jwt.TokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserLoginService(
    private val userFacade: UserFacade,
    private val passwordEncoder: PasswordEncoder,
    private val tokenProvider: TokenProvider
) {

    @Transactional
    fun execute(request: UserLoginRequest): TokenResponse {
        val user = userFacade.getByAccountId(request.accountId)

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordMismatchedException
        }
        return tokenProvider.getToken(user.accountId)
    }
}