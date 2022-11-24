package de.bsi.itemapi.service

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class IdGenerator {

    @Value("\${idgenerator.prefix}") lateinit var prefix : String

    fun generateId() = prefix + UUID.randomUUID().toString()

    @PostConstruct
    fun setup() {
        //println("Start of Bean lifecycle.")
    }

    @PreDestroy
    fun shutdown() {
        //println("End of Bean lifecycle.")
    }
}