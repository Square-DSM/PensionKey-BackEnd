package com.example.pensionkeybackend.global.security

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.context.annotation.Configuration


@OpenAPIDefinition(
    info = Info(
        title = "SQUARE : Pension-Key API 명세서",
        description = "Pension-Key",
        contact = Contact(name = "SQUARE")
    )
)
@Configuration
class SwaggerConfig