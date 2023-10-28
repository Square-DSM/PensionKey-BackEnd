package com.example.pensionkeybackend.domain.user.domain.repository

import com.example.pensionkeybackend.domain.user.domain.User
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepository : CrudRepository<User, UUID>