package com.example.pensionkeybackend.domain.user.presentation

import com.example.pensionkeybackend.domain.user.presentation.dto.QueryUserResponse
import com.example.pensionkeybackend.domain.user.presentation.dto.TokenResponse
import com.example.pensionkeybackend.domain.user.presentation.dto.UserLoginRequest
import com.example.pensionkeybackend.domain.user.presentation.dto.UserSignUpRequest
import com.example.pensionkeybackend.domain.user.service.QueryUserService
import com.example.pensionkeybackend.domain.user.service.UserLoginService
import com.example.pensionkeybackend.domain.user.service.UserSignUpService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@Tag(name = "유저")
@RequestMapping("/users")
@RestController
class UserController(
    private val userSignUpService: UserSignUpService,
    private val userLoginService: UserLoginService,
    private val queryUserService: QueryUserService,
) {

    @Operation(summary = "회원가입")
    @ResponseStatus(CREATED)
    @PostMapping("/signup")
    fun signup(@RequestBody @Valid request: UserSignUpRequest) {
        userSignUpService.execute(request)
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    fun login(@RequestBody @Valid request: UserLoginRequest): TokenResponse {
        return userLoginService.execute(request)
    }

    @Operation(summary = "유저 정보 조회")
    @GetMapping
    fun getUserInfo(): QueryUserResponse {
        return queryUserService.execute()
    }
}