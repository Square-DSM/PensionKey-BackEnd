package com.example.pensionkeybackend.domain.comment.domain.repository

import com.example.pensionkeybackend.domain.comment.domain.Comment
import com.example.pensionkeybackend.domain.comment.presentation.response.CommentElement
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface CommentRepository : CrudRepository<Comment, UUID> {
    fun findAllByFeedId(feedId: UUID): List<CommentElement>
}