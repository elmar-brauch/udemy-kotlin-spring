package de.bsi.itemapi.model

import jakarta.validation.constraints.Pattern
import java.time.LocalDate

data class Item(
    @field:Pattern(regexp = "[a-zA-Z]+") val name: String,
    var id: String?,
    val date: LocalDate = LocalDate.now())
