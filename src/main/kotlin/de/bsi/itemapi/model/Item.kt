package de.bsi.itemapi.model

import java.time.LocalDate

data class Item(val name: String, var id: String?, val date: LocalDate = LocalDate.now())
