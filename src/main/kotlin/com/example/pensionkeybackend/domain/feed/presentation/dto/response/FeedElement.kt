package com.example.pensionkeybackend.domain.feed.presentation.dto.response

import java.time.LocalDate
import java.util.UUID

data class FeedElement(
    val title: String,
    val userId: UUID,
    val createDate: LocalDate
)