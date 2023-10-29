package com.example.pensionkeybackend.global.security

import com.example.pensionkeybackend.global.error.ExceptionFilter
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.AuthenticationFilter

class FilterConfig(
    private val objectMapper: ObjectMapper,
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(ExceptionFilter(objectMapper), AuthenticationFilter::class.java)
    }
}
