package com.example.pensionkeybackend.domain.user.presentation.dto

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String
)