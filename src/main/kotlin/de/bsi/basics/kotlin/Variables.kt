package de.bsi.basics.kotlin

fun main() {
    // final variable defined with keyword val.
    val finalVariable = Variables("final String")
    finalVariable.printValues()
    // non-final variables defined with keyword var can be changed.
    finalVariable.age++
    finalVariable.printValues()
}

// Parameter name must be defined in constructor call.
// Parameter age is optional constructor parameter, which can overwrite the default value 10 if set.
class Variables(val name: String, var age: Int = 10) {

    // No access to private variables outside the class
    private var text = "Parameter name: "
    private val replacement = "age"

    fun printValues() {
        println(text + name)
        text = text.replace("name", replacement)
        println(text + age)
    }

}