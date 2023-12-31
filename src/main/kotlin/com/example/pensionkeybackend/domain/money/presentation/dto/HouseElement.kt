package com.example.pensionkeybackend.domain.money.presentation.dto

import java.time.LocalDate
import java.util.UUID

data class HouseElement(
    val id: UUID,
    val paymentType: String,
    val expectPension: Int,
    val pensionEndDate: LocalDate,
)
