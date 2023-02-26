package de.bsi.basics

// Static main method to start the program
fun main() {
    println(Functions().getMessage())
    println(getMessageFor("Kotlin Fans"))
}

class Functions {
    // Non-static method, which returns a String value.
    fun getMessage() : String {
        return "Hello from function"
    }
}

// Static method with parameter.
// Function type & return keyword are not required, because body is only one statement
fun getMessageFor(student: String) = "Hello %s".format(student)