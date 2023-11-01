package com.example.pensionkeybackend.domain.money.service

import com.example.pensionkeybackend.domain.money.domain.repository.HouseRepository
import com.example.pensionkeybackend.domain.money.domain.repository.PensionRepository
import com.example.pensionkeybackend.domain.money.exception.HouseNotFoundException
import com.example.pensionkeybackend.domain.money.exception.PensionNotFoundException
import com.example.pensionkeybackend.domain.money.presentation.dto.QueryHouseDetailsResponse
import com.example.pensionkeybackend.domain.money.presentation.dto.QueryPensionDetailsResponse
import com.example.pensionkeybackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class QueryHouseDetailsService(
    private val houseRepository: HouseRepository
) {

    fun execute(houseId: UUID): QueryHouseDetailsResponse {
        return houseRepository.findHouseById(houseId)
    }
}