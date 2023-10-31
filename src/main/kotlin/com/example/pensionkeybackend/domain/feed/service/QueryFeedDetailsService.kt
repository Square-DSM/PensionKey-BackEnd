package com.example.pensionkeybackend.domain.feed.service

import com.example.pensionkeybackend.domain.feed.domain.repository.FeedRepository
import com.example.pensionkeybackend.domain.feed.exception.FeedNotFoundException
import com.example.pensionkeybackend.domain.feed.presentation.dto.response.QueryFeedDetailsResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class QueryFeedDetailsService(
    private val feedRepository: FeedRepository
) {

    @Transactional(readOnly = true)
    fun execute(feedId: UUID) : QueryFeedDetailsResponse {
        val feed = feedRepository.findById(feedId).orElseThrow{FeedNotFoundException}

        return QueryFeedDetailsResponse(
            id = feed.id,
            title = feed.title,
            content = feed.content
        )
    }
}