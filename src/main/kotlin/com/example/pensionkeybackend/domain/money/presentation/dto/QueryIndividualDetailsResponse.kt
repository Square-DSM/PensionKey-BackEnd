package com.example.pensionkeybackend.domain.money.presentation.dto

import java.time.LocalDate
import javax.persistence.Column

data class QueryIndividualDetailsResponse(
    val companyName: String,
    val productName: String,
    val totalPaymentAmt: Int,
    val expectPension: Int,
)