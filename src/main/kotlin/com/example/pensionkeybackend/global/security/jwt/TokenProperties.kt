package com.example.pensionkeybackend.global.security.jwt
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
data class TokenProperties(
    var secret: String,
    val accessExp: Long,
    val refreshExp: Long
)