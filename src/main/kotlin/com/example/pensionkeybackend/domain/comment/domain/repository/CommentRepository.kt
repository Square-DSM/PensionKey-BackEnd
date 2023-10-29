package com.example.pensionkeybackend.domain.comment.domain.repository

import com.example.pensionkeybackend.domain.comment.domain.Comment
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface CommentRepository : CrudRepository<Comment, UUID>