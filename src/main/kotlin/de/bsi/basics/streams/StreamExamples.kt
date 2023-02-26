package de.bsi.basics.streams

import java.util.stream.Collectors

val names = listOf("Ardbeg", "Lagavulin", "Jim Beam", "Teeling", "Jameson", "Johnny Walker")

data class Whisky(val name: String, val length: Int)

fun demoMapAndToList(): List<Whisky> {
    // Map all Strings to Whisky objects and collect in List.
    val whiskies = names.stream()
        .map { name -> Whisky(name, name.length) }
        .toList()
    println(whiskies)
    return whiskies
}

fun main() {
    val whiskies = demoMapAndToList()
    demoSortedAndForEach(whiskies)
    demoFilterAndCount(whiskies)
    demoPeekAndFindFirst(whiskies)
    demoMatch(whiskies)
    demoGroupBy(whiskies)
    demoParallelProcessing(whiskies)
}

fun demoSortedAndForEach(whiskies: List<Whisky>) {
    // Sort objects in Stream and consume each.
    whiskies.stream()
        .sorted { a, b -> b.length - a.length }
        .forEach { println(it) }
}

private fun demoFilterAndCount(whiskies: List<Whisky>) {
    // Count objects in Stream, which match filter condition
    val countLength7 = whiskies.stream()
        .filter { it.length == 7 }
        .count()
    println(countLength7)
}

fun demoPeekAndFindFirst(whiskies: List<Whisky>) {
    // Find first object in Stream, which matches filter condition, additionally its position is counted.
    var counter = 0
    whiskies.stream()
        .peek { _ -> counter++ }
        .filter { it.name.contains("J") }
        .findFirst()
        .ifPresent { whisky -> println("Found ${whisky.name} at position $counter") }
}

fun demoMatch(whiskies: List<Whisky>) {
    // Check condition of all elements in Stream
    println("All Whiskies have name with more than 0 characters: " +
            whiskies.stream().allMatch { it.length > 0 })
    println("No Whisky has name with more than 0 characters: " +
            whiskies.stream().noneMatch { it.length > 0 })
    println("Any Whisky has name with more than 10 characters: " +
            whiskies.stream().noneMatch { it.length > 10 })
}

fun demoGroupBy(whiskies: List<Whisky>) {
    // Group Whiskies by attribute
    val groupsAsMap = whiskies.stream()
        .collect(Collectors.groupingBy { it.length })
    groupsAsMap.forEach(::println)
}

fun demoParallelProcessing(whiskies: List<Whisky>) {
    whiskies.stream().parallel().forEach(::println)
    // 10 times bigger Stream.
    IntRange(0,10).flatMap { _ -> whiskies }.parallelStream().forEach(::println)
}