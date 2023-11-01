package com.example.pensionkeybackend.domain.money.domain.repository

import com.example.pensionkeybackend.domain.money.domain.House
import com.example.pensionkeybackend.domain.money.presentation.dto.HouseElement
import com.example.pensionkeybackend.domain.money.presentation.dto.QueryHouseDetailsResponse
import com.example.pensionkeybackend.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface HouseRepository: JpaRepository<House, UUID> {
    fun findAllByUser(user: User): List<HouseElement>
    fun findHouseById(houseId: UUID): QueryHouseDetailsResponse
}