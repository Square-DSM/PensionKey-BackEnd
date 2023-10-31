package com.example.pensionkeybackend.domain.money.domain

import com.example.pensionkeybackend.domain.user.domain.User
import com.example.pensionkeybackend.global.entity.BaseUUIDEntity
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "tbl_house")
class House(
    @Column(columnDefinition = "VARCHAR(200)", nullable = false)
    val paymentType: String,

    @Column(columnDefinition = "INT(1000000)", nullable = false)
    val expectPension: Int,

    @Column(columnDefinition = "DATE", nullable = false)
    val pensionEndDate: LocalDate,

    @Column(columnDefinition = "VARCHAR(200)", nullable = false)
    val managementBranch: String,

    user: User
): BaseUUIDEntity() {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    val user = user
}