package com.example.pensionkeybackend.domain.user.domain

import com.example.pensionkeybackend.global.entity.BaseUUIDEntity
import org.hibernate.annotations.ColumnDefault
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Table(name = "tbl_user")
@Entity
class User(
    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    val accountId: String,

    @Column(columnDefinition = "CHAR(60)", nullable = false)
    val password: String,

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    val name: String,

    @Column(columnDefinition = "CHAR(4)", nullable = false)
    @ColumnDefault("0001")
    val organizationCode: String,

    @Column(columnDefinition = "CHAR(3)", nullable = false)
    val certType: String,

    @Column(columnDefinition = "INT(15)", nullable = false)
    val identity: Int,

    @Column(columnDefinition = "VARCHAR(100)")
    val certFile: String?,

    @Column(columnDefinition = "VARCHAR(100)")
    val keyFile: String?,

    @Column(columnDefinition = "VARCHAR(60)")
    val certPassword: String?
): BaseUUIDEntity()