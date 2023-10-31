package com.example.pensionkeybackend.domain.comment.service

import com.example.pensionkeybackend.domain.comment.domain.repository.CommentRepository
import com.example.pensionkeybackend.domain.feed.facade.FeedFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class DeleteCommentService(
    private val commentRepository: CommentRepository,
    private val feedFacade: FeedFacade
) {

    @Transactional
    fun execute(commentId: UUID, feedId: UUID) {
        feedFacade.existByFeedId(feedId)
        commentRepository.deleteById(commentId)
    }
}