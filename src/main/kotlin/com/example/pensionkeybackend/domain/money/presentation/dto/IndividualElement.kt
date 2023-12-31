package com.example.pensionkeybackend.domain.money.presentation.dto

import java.time.LocalDate
import java.util.UUID

data class IndividualElement(
    val id: UUID,
    val companyName: String,
    val productName: String,
    val totalPaymentAmt: Int,
)
