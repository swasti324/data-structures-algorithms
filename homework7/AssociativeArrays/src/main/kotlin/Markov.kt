import java.io.File

class CustomMarkovAnalyzer {

    fun analyze(targetWord: String):Int {
        val inputFile = File("/home/swasti/Documents/Data Structures and Algorithms/data-structures-algorithms/homework7/AssociativeArrays/src/bee-movie.txt")
        val fileText = inputFile.readText()

        val words = fileText.split("\\s+".toRegex())

        val cleanWords: List<String> = words.map { it.replace(Regex("[^A-Za-z0-9]"), "") }
            .filter { it.isNotBlank() }

        var count = 0
        println("Occurrences of '$targetWord':")
        for (i in 0 until cleanWords.size - 1) {
            if (cleanWords[i] == targetWord) {
                val nextWord = cleanWords[i + 1]
                println(nextWord)
                count++
            }
        }
        println("Total occurrences: $count")
        return count
    }
}
