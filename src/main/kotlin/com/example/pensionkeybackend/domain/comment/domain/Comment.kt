package com.example.pensionkeybackend.domain.comment.domain

import com.example.pensionkeybackend.domain.feed.domain.Feed
import com.example.pensionkeybackend.domain.user.domain.User
import com.example.pensionkeybackend.global.entity.BaseUUIDEntity
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Table(name = "tbl_comment")
@Entity
class Comment(

    @Column(columnDefinition = "VARCHAR(500)", nullable = false)
    val content: String,

    user: User,

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    val userAccountId: String,

    @Column(columnDefinition = "DATE", nullable = false)
    val createdAt: LocalDate,

    feed: Feed
) : BaseUUIDEntity() {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    val user = user

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", columnDefinition = "BINARY(16)", nullable = false)
    val feed = feed
}