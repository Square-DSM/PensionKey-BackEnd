package com.example.pensionkeybackend.global.error

abstract class GlobalException(
    val errorProperty: ErrorProperty
) : RuntimeException() {

    override fun fillInStackTrace() = this
}