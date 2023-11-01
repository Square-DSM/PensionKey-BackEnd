package com.example.pensionkeybackend.domain.money.presentation.dto

import java.util.UUID

data class PensionElement(
    val id: UUID,
    val expectTotalPay: Int,
    val payMonth: Int,
)
