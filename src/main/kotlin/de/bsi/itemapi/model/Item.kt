package de.bsi.itemapi.model

import java.time.LocalDate
import javax.validation.constraints.Pattern

data class Item(
    @field:Pattern(regexp = "[a-zA-Z]+") val name: String,
    var id: String?,
    val date: LocalDate = LocalDate.now())
