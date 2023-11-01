package com.example.pensionkeybackend.domain.feed.presentation.dto.response

import java.time.LocalDate
import java.util.*

data class QueryFeedListResponse(
    val feedList: List<FeedVo>
)