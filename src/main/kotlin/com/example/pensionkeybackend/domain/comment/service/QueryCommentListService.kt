package com.example.pensionkeybackend.domain.comment.service

import com.example.pensionkeybackend.domain.comment.domain.repository.CommentRepository
import com.example.pensionkeybackend.domain.comment.presentation.response.CommentElement
import com.example.pensionkeybackend.domain.feed.facade.FeedFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class QueryCommentListService(
    private val commentRepository: CommentRepository,
    private val feedFacade: FeedFacade
){

    @Transactional(readOnly = true)
    fun execute(feedId: UUID) : List<CommentElement> =
        commentRepository.findAllByFeedId(feedFacade.getFeedById(feedId).id)
}