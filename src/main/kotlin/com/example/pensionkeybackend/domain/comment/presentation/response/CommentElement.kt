package com.example.pensionkeybackend.domain.comment.presentation.response

import java.time.LocalDateTime
import java.util.UUID

data class CommentElement(
    val id: UUID,
    val content: String,
    val userAccountId: String,
    val createdAt: LocalDateTime,
)