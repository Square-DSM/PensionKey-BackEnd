package com.example.pensionkeybackend.domain.money.service

import com.example.pensionkeybackend.domain.money.domain.repository.HouseRepository
import com.example.pensionkeybackend.domain.money.presentation.dto.HouseElement
import com.example.pensionkeybackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryHouseListService(
    private val houseRepository: HouseRepository,
    private val userFacade: UserFacade
) {
    @Transactional(readOnly = true)
    fun execute(): List<HouseElement> {
        val user = userFacade.getCurrentUser()
        return houseRepository.findAllByUser(user)
    }
}