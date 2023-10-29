package com.example.pensionkeybackend.domain.feed.domain

import com.example.pensionkeybackend.domain.user.domain.User
import com.example.pensionkeybackend.global.entity.BaseUUIDEntity
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Table(name = "tbl_feed")
@Entity
class Feed(
    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    val title: String,

    @Column(columnDefinition = "VARCHAR(2000)", nullable = false)
    val content: String,

    @Column(columnDefinition = "DATE", nullable = false)
    val createdAt: LocalDate,

    user: User
) : BaseUUIDEntity() {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    val user = user
}