package com.example.pensionkeybackend.domain.user.domain.repository

import com.example.pensionkeybackend.domain.user.domain.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository: CrudRepository<RefreshToken, String>