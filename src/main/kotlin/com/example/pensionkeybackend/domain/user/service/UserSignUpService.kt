package com.example.pensionkeybackend.domain.user.service

import com.example.pensionkeybackend.domain.user.domain.User
import com.example.pensionkeybackend.domain.user.domain.repository.UserRepository
import com.example.pensionkeybackend.domain.user.exception.AlreadyUserException
import com.example.pensionkeybackend.domain.user.presentation.dto.UserSignUpRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserSignUpService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,

) {
    fun execute(request: UserSignUpRequest) {
        if(userRepository.existsByAccountId(request.accountId)) {
            throw AlreadyUserException
        }

        userRepository.save(
            User(
                accountId = request.accountId,
                password = passwordEncoder.encode(request.password),
                name = request.name,
                organizationCode = request.organizationCode,
                certType = request.certType,
                identity = request.identity,
                certFile = request.certFile,
                keyFile = request.keyFile,
                certPassword = request.certPassword
            )
        )
    }
}