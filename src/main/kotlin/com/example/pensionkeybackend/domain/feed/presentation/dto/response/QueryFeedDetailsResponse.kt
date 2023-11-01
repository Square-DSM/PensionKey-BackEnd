package com.example.pensionkeybackend.domain.feed.presentation.dto.response

import com.example.pensionkeybackend.domain.comment.presentation.response.CommentElement
import java.time.LocalDate
import java.util.UUID

data class QueryFeedDetailsResponse(
    val id: UUID,
    val title: String,
    val content: String,
    val createdAt: LocalDate,
    val userAccountId: String
)