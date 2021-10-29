package de.bsi.itemapi.service

import org.springframework.stereotype.Component
import java.util.*

@Component
class IdGenerator {
    fun generateId() = UUID.randomUUID().toString()
}