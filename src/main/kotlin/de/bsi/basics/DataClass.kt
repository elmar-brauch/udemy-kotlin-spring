package de.bsi.basics

// Data classes are used to store data - no boilerplate code for equals, hashCode, toString, etc required.
data class ItemDataClass(val name: String, val id: Int, var active: Boolean)

class ItemClassicClass(val name: String, val id: Int, var active: Boolean)

fun main() {
    val itemClassic = ItemClassicClass("Classic class", 201, false)
    val itemData = ItemDataClass("Data class", 101, false)

    println("Normal class has default toString method: " + itemClassic.toString())
    println("Data class has proper toString method: " + itemData.toString())

    val itemDataCopy = itemData.copy()
    println("Data class has copy method and proper equals method: " + itemDataCopy.equals(itemData))

    val itemClassicCopy = ItemClassicClass("Classic class", 201, false)
    println("Normal class checks equals only for references: " + itemClassicCopy.equals(itemClassic))
}