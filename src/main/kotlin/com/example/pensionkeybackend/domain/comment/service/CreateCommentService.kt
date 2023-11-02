package com.example.pensionkeybackend.domain.comment.service

import com.example.pensionkeybackend.domain.comment.domain.Comment
import com.example.pensionkeybackend.domain.comment.domain.repository.CommentRepository
import com.example.pensionkeybackend.domain.comment.presentation.request.CreateCommentRequest
import com.example.pensionkeybackend.domain.feed.facade.FeedFacade
import com.example.pensionkeybackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*

@Service
class CreateCommentService(
    private val commentRepository: CommentRepository,
    private val feedFacade: FeedFacade,
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(feedId: UUID, request: CreateCommentRequest) {
        val feed = feedFacade.getFeedById(feedId)
        val user = userFacade.getCurrentUser()

        commentRepository.save(
            Comment(
                content = request.content,
                user = user,
                feed = feed,
                createdAt = LocalDateTime.now(),
                userAccountId = user.accountId
            )
        )
    }
}