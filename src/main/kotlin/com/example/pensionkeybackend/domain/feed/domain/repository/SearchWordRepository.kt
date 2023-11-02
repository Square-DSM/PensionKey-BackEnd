package com.example.pensionkeybackend.domain.feed.domain.repository

import com.example.pensionkeybackend.domain.feed.domain.SearchWord
import com.example.pensionkeybackend.domain.feed.presentation.dto.response.SearchKeyElement
import com.example.pensionkeybackend.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SearchWordRepository : JpaRepository<SearchWord, UUID> {
    fun findAllByUser(user: User): List<SearchKeyElement>
}