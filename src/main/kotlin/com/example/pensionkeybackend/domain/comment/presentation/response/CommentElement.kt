package com.example.pensionkeybackend.domain.comment.presentation.response

import java.util.UUID

data class CommentElement(
    val id: UUID,
    val content: String,
    val accountId: String
)