package de.bsi.itemapi.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

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