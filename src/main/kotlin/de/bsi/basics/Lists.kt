package de.bsi.basics

fun main() {
    val mutableList = mutableListOf<String>()
    mutableList.add("Adding elements is")
    mutableList.add("possible")

    val immutableList = listOf("Adding", "more", "not", "possible")
    // List interface in Kotlin offers no method to add more elements
    println(mutableList.get(1) == immutableList.last())

    println("\nFor each loop: ")
    for (element in mutableList)
        println(element)

    println("\nSimple Stream example - it is lambda expression simplification: ")
    immutableList.stream().forEach { println(it) }
}
