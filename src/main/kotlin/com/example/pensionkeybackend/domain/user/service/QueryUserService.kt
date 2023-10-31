package com.example.pensionkeybackend.domain.user.service

import com.example.pensionkeybackend.domain.user.facade.UserFacade
import com.example.pensionkeybackend.domain.user.presentation.dto.QueryUserResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryUserService(
    private val userFacade: UserFacade
) {
    @Transactional(readOnly = true)
    fun execute(): QueryUserResponse {
        val user = userFacade.getCurrentUser()
        return QueryUserResponse(
            name = user.name,
            accountId = user.accountId
        )
    }
}