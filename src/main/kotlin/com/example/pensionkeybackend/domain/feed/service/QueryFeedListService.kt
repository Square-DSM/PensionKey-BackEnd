package com.example.pensionkeybackend.domain.feed.service

import com.example.pensionkeybackend.domain.comment.domain.repository.CommentRepository
import com.example.pensionkeybackend.domain.feed.domain.repository.FeedRepository
import com.example.pensionkeybackend.domain.feed.presentation.dto.response.FeedVo
import com.example.pensionkeybackend.domain.feed.presentation.dto.response.QueryFeedListResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryFeedListService(
    private val feedRepository: FeedRepository,
    private val commentRepository: CommentRepository,
) {
    @Transactional(readOnly = true)
    fun execute(): QueryFeedListResponse {
        val feedList = feedRepository.findAllByOrderByCreatedAt()

        return QueryFeedListResponse(feedList.map {
            FeedVo(
                id = it.id,
                title = it.title,
                createdAt = it.createdAt,
                commentCount = commentRepository.countCommentByFeedId(it.id),
                userAccountId = it.userAccountId
            )
        }
        )
    }
}