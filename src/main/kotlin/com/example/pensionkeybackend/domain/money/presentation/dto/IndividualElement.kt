package com.example.pensionkeybackend.domain.money.presentation.dto

import java.time.LocalDate

data class IndividualElement(
    val companyName: String,
    val productName: String,
    val totalPaymentAmt: Int,
)
