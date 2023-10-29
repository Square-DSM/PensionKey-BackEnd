package com.example.pensionkeybackend.global.security

import com.example.pensionkeybackend.global.security.jwt.TokenFilter
import com.example.pensionkeybackend.global.security.jwt.TokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class SecurityConfig(
    private val objectMapper: ObjectMapper,
    private val tokenProvider: TokenProvider,
) {

    @Bean
    @Throws(Exception::class)
    protected fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        http
            .formLogin().disable()
            .csrf().disable()
            .cors().and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http
            .authorizeRequests()
            // .antMatchers("/admin/head").hasAuthority(UserRole.SCH.name) TODO: 권한 설정하기
            .anyRequest().permitAll()

        http
            .apply(FilterConfig(objectMapper, tokenProvider))

        return http.build()
    }

    @Bean
    fun passwordEncorder(): PasswordEncoder = BCryptPasswordEncoder()
}
