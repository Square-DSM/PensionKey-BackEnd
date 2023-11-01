package com.example.pensionkeybackend.domain.comment.presentation.response

import com.example.pensionkeybackend.domain.user.domain.User
import java.util.UUID

data class CommentElement(
    val id: UUID,
    val content: String,
    val userAccountId: String
)