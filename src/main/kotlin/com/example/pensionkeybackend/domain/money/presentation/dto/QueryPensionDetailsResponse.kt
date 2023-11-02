package com.example.pensionkeybackend.domain.money.presentation.dto

import java.time.LocalDate

data class QueryPensionDetailsResponse(
    val meanMonthlyIncome: Int,
    val expectTotalPay: Int,
    val payMonth: Int,
    val pensionPayDate: LocalDate
)