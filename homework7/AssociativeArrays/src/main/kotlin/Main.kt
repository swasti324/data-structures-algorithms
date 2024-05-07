package org.example
import CustomMarkovAnalyzer

/**
 * Main function to analyze occurrences of selected words in the Bee Movie script
 * and visualize the results using a simple text-based graph.
 */
fun main() {
    val analyzer = CustomMarkovAnalyzer()

    val wordsToAnalyze = listOf("bee", "honey", "love", "hive", "queen", "worker", "human", "pollen")

    val totalOccurrences = mutableMapOf<String, Int>()

    for (word in wordsToAnalyze) {
        println("Analyzing occurrences of '$word'...")

        // Analyze the occurrences of the current word using the CustomMarkovAnalyzer
        val occurrences = analyzer.analyze(word)

        // Store the total occurrences of the current word in the totalOccurrences map
        totalOccurrences[word] = occurrences

        println("--------------------------------------------------")
    }

    // Print the total occurrences of each word
    println("Total Occurrences:")
    totalOccurrences.forEach { (word, occurrences) ->
        println("$word: $occurrences")
    }

    println("\nGraph:")
    totalOccurrences.forEach { (word, occurrences) ->
        // Create a bar graph using '#' characters to represent the occurrences
        val bar = "#".repeat(occurrences)
        println("$word: $bar ($occurrences)")
    }
}
