package de.bsi.basics.kotlin

fun main() {
    val test = NullSafety("Compile does not allow null here!", "String? can be null")
    test.nullableText = null

    // The following lines produce compile errors due to Kotlin's null safety
    // test.nonNullableText = null
    // test.nullableText.uppercase()

    println("null is handled by ? as: " + test.nullableText?.uppercase())
    println("null safety is ignored by !!" + test.nullableText!!.uppercase())
}

data class NullSafety(var nonNullableText: String, var nullableText: String?) {}