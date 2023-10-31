package com.example.pensionkeybackend.domain.money.service

import com.example.pensionkeybackend.domain.money.domain.repository.PensionRepository
import com.example.pensionkeybackend.domain.money.presentation.dto.PensionElement
import com.example.pensionkeybackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryPensionListService(
    private val userFacade: UserFacade,
    private val pensionRepository: PensionRepository
) {
    @Transactional(readOnly = true)
    fun execute(): List<PensionElement> {
        val user = userFacade.getCurrentUser()
        return pensionRepository.findAllByUser(user)
    }
}