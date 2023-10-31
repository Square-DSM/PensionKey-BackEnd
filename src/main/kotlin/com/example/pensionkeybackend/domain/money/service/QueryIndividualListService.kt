package com.example.pensionkeybackend.domain.money.service

import com.example.pensionkeybackend.domain.money.domain.repository.IndividualRepository
import com.example.pensionkeybackend.domain.money.presentation.dto.IndividualElement
import com.example.pensionkeybackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryIndividualListService(
    private val userFacade: UserFacade,
    private val individualRepository: IndividualRepository
) {
    @Transactional(readOnly = true)
    fun execute(): List<IndividualElement> {
        val user = userFacade.getCurrentUser()
        return individualRepository.findAllByUser(user)
    }
}