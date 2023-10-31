package com.example.pensionkeybackend.domain.money.presentation.dto

import java.time.LocalDate

data class HouseElement(
    val paymentType: String,
    val expectPension: Int,
    val pensionEndDate: LocalDate,
)
