package de.bsi.basics

import java.time.DayOfWeek
import java.time.LocalDate

fun main() {
    demoIfClassic()
    demoIfExpression()
}

fun demoIfClassic() {
    val now = LocalDate.now()
    if (DayOfWeek.MONDAY.equals(now.dayOfWeek)) {
        println("Classic if as in Java")
    } else {
        println("Classic else as in Java")
    }
}

fun demoIfExpression() {
    val text = if (DayOfWeek.MONDAY.equals(LocalDate.now().dayOfWeek))
        "If Expression assigns this String to text"
    else
        "Else assigns this to text"
    println(text)
}

