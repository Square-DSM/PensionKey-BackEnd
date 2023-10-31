package com.example.pensionkeybackend.domain.comment.presentation

import com.example.pensionkeybackend.domain.comment.presentation.request.CreateCommentRequest
import com.example.pensionkeybackend.domain.comment.service.CreateCommentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


@RequestMapping("/comment")
@RestController
class CommentController(
    private val createCommentService: CreateCommentService
){

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed_id}")
    fun createComment(@PathVariable(name = "feed_id") feedId: UUID ,request: CreateCommentRequest) =
        createCommentService.execute(feedId, request)

}