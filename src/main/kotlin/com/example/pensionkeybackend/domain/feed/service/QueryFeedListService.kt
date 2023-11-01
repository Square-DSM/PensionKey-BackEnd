package com.example.pensionkeybackend.domain.feed.service

import com.example.pensionkeybackend.domain.feed.domain.repository.FeedRepository
import com.example.pensionkeybackend.domain.feed.presentation.dto.response.FeedElement
import com.example.pensionkeybackend.domain.feed.presentation.dto.response.QueryFeedListResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryFeedListService(
    private val feedRepository: FeedRepository
) {
    @Transactional(readOnly = true)
    fun execute() : QueryFeedListResponse = QueryFeedListResponse(feedRepository.findAllByOrderByCreatedAt())
}