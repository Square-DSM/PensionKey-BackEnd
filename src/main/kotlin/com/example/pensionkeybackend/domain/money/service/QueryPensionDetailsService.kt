package com.example.pensionkeybackend.domain.money.service

import com.example.pensionkeybackend.domain.money.domain.repository.PensionRepository
import com.example.pensionkeybackend.domain.money.exception.PensionNotFoundException
import com.example.pensionkeybackend.domain.money.presentation.dto.QueryPensionDetailsResponse
import com.example.pensionkeybackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class QueryPensionDetailsService(
    private val pensionRepository: PensionRepository,
    private val userFacade: UserFacade
) {

    fun execute(): QueryPensionDetailsResponse {
        val user = userFacade.getCurrentUser()
        val pension = pensionRepository.findByUser(user)?: throw PensionNotFoundException

        return QueryPensionDetailsResponse(
            meanMonthlyIncome = pension.meanMonthlyIncome,
            expectTotalPay = pension.expectTotalPay,
            payMonth = pension.payMonth,
            pensionPayDate = pension.pensionPayDate
        )
    }
}