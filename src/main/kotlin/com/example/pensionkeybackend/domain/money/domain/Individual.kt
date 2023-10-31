package com.example.pensionkeybackend.domain.money.domain

import com.example.pensionkeybackend.domain.user.domain.User
import com.example.pensionkeybackend.global.entity.BaseUUIDEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "tbl_individual")
class Individual(

    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    val companyName: String,

    @Column(columnDefinition = "VARCHAR(200)", nullable = false)
    val productName: String,

    @Column(columnDefinition = "INT(1000000)", nullable = false)
    val totalPaymentAmt: Int,

    @Column(columnDefinition = "INT(1000000)", nullable = false)
    val expectPension: Int,
    user: User
): BaseUUIDEntity() {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    val user = user
}