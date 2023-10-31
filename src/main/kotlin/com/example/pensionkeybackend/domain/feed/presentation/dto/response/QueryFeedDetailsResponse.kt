package com.example.pensionkeybackend.domain.feed.presentation.dto.response

import java.util.UUID

data class QueryFeedDetailsResponse(
    val id: UUID,
    val title: String,
    val content: String
)