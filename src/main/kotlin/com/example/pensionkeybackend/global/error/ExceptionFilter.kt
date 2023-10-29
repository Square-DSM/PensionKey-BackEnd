package com.example.pensionkeybackend.global.error

import com.example.pensionkeybackend.global.exception.InternalServerErrorException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            when (e.cause) {
                is GlobalException -> {
                    errorToJson((e.cause as GlobalException).errorProperty, response)
                }

                is Exception -> {
                    errorToJson(InternalServerErrorException.errorProperty, response)
                }
            }
        }
    }

    private fun errorToJson(errorProperty: ErrorProperty, response: HttpServletResponse) {
        response.apply {
            status = errorProperty.status()
            characterEncoding = StandardCharsets.UTF_8.name()
            contentType = MediaType.APPLICATION_JSON_VALUE
            writer.write(objectMapper.writeValueAsString(errorProperty.of()))
        }
    }
}
