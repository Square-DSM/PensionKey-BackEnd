package com.example.pensionkeybackend.domain.feed.domain.repository

import com.example.pensionkeybackend.domain.feed.domain.Feed
import com.example.pensionkeybackend.domain.feed.presentation.dto.response.FeedElement
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface FeedRepository : CrudRepository<Feed, UUID> {
    fun findAllByOrderByCreatedAt(): List<FeedElement>
}