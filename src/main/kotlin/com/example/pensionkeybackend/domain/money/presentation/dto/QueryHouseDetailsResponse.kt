package com.example.pensionkeybackend.domain.money.presentation.dto

import java.time.LocalDate
import javax.persistence.Column

data class QueryHouseDetailsResponse(
    val paymentType: String,
    val expectPension: Int,
    val pensionEndDate: LocalDate,
    val managementBranch: String,
)