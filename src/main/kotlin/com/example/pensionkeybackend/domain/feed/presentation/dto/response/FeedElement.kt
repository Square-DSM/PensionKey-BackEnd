package com.example.pensionkeybackend.domain.feed.presentation.dto.response

import java.time.LocalDateTime
import java.util.UUID

data class FeedElement(
    val id: UUID,
    val title: String,
    val userAccountId: String,
    val createdAt: LocalDateTime
)