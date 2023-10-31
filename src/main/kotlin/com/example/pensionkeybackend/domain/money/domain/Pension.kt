package com.example.pensionkeybackend.domain.money.domain

import com.example.pensionkeybackend.domain.user.domain.User
import com.example.pensionkeybackend.global.entity.BaseUUIDEntity
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "tbl_pension")
class Pension(
    @Column(columnDefinition = "INT(10000)", nullable = false)
    val meanMonthlyIncome: Int,

    @Column(columnDefinition = "INT(1000000)", nullable = false)
    val expectTotalPay: Int,

    @Column(columnDefinition = "INT(2)", nullable = false)
    val payMonth: Int,

    @Column(columnDefinition = "DATE", nullable = false)
    val pensionPayDate: LocalDate,

    user: User
):BaseUUIDEntity() {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    val user = user
}