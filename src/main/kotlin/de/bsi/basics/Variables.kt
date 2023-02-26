package de.bsi.basics

fun main() {
    val finalVariable = Variables("final String")
    finalVariable.printValues()
    finalVariable.age = 11
    finalVariable.printValues()
}

class Variables(val name : String, var age : Int = 2) {

    private var text = "Parameter name = "
    private val replacement = "age"

    fun printValues() {
        println(text + name)
        text = text.replace("name", replacement)
        println(text + age)
    }
}