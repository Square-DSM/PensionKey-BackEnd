package com.example.pensionkeybackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class PensionKeyBackendApplication

fun main(args: Array<String>) {
    runApplication<PensionKeyBackendApplication>(*args)
}
