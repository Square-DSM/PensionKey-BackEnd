package com.example.pensionkeybackend.domain.money.presentation.dto

import java.time.LocalDateTime

data class QueryPensionDetailsResponse(
    val meanMonthlyIncome: Int,
    val expectTotalPay: Int,
    val payMonth: Int,
    val pensionPayDate: LocalDateTime
)