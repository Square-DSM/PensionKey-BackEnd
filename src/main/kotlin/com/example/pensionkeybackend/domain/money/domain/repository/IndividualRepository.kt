package com.example.pensionkeybackend.domain.money.domain.repository

import com.example.pensionkeybackend.domain.money.domain.Individual
import com.example.pensionkeybackend.domain.money.presentation.dto.IndividualElement
import com.example.pensionkeybackend.domain.money.presentation.dto.QueryIndividualDetailsResponse
import com.example.pensionkeybackend.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface IndividualRepository : JpaRepository<Individual, UUID> {
    fun findAllByUser(user: User): List<IndividualElement>
    fun findIndividualById(individualId: UUID): QueryIndividualDetailsResponse
}