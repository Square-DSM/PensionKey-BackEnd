package com.example.pensionkeybackend.domain.comment.presentation

import com.example.pensionkeybackend.domain.comment.presentation.request.CreateCommentRequest
import com.example.pensionkeybackend.domain.comment.service.CreateCommentService
import com.example.pensionkeybackend.domain.comment.service.DeleteCommentService
import com.example.pensionkeybackend.domain.comment.service.QueryCommentListService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


@RequestMapping("/comment")
@RestController
class CommentController(
    private val createCommentService: CreateCommentService,
    private val deleteCommentService: DeleteCommentService,
    private val queryCommentListService: QueryCommentListService
){

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed_id}")
    fun createComment(@PathVariable(name = "feed_id") feedId: UUID , request: CreateCommentRequest) =
        createCommentService.execute(feedId, request)


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{comment_id}")
    fun deleteComment(@PathVariable(name = "comment_id") commentId: UUID, @RequestParam feedId: UUID) =
        deleteCommentService.execute(commentId, feedId)

    @GetMapping("/{feed_id}")
    fun queryCommentList(@PathVariable(name = "feed_id") feedId: UUID) =
        queryCommentListService.execute(feedId)
}