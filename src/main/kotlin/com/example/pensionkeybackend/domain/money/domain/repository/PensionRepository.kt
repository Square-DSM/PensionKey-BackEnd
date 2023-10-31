package com.example.pensionkeybackend.domain.money.domain.repository

import com.example.pensionkeybackend.domain.money.domain.Pension
import com.example.pensionkeybackend.domain.money.presentation.dto.PensionElement
import com.example.pensionkeybackend.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PensionRepository: JpaRepository<Pension, UUID> {
    fun findAllByUser(user: User): List<PensionElement>
}