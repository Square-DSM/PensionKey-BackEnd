package com.example.pensionkeybackend.domain.money.service

import com.example.pensionkeybackend.domain.money.domain.repository.IndividualRepository
import com.example.pensionkeybackend.domain.money.presentation.dto.QueryIndividualDetailsResponse
import org.springframework.stereotype.Service
import java.util.*

@Service
class QueryIndividualDetailsService(
    private val individualRepository: IndividualRepository
) {

    fun execute(individualId: UUID): QueryIndividualDetailsResponse {
        return individualRepository.findIndividualById(individualId)
    }
}