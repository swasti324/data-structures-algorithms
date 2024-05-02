import org.example.SelectionSort
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SelectionSortTest {
    val selection = SelectionSort()
    @Test
    fun selectionTest1() {
        val unsortedArray = intArrayOf(64, 25, 12, 22, 11)
        val sortedArray = intArrayOf(11, 12, 22, 25, 64)

        selection.selectionSort(unsortedArray)
        assertArrayEquals(sortedArray, unsortedArray)
    }
    @Test
    fun selectionTest2() {
        val unsortedArray = intArrayOf(0, 0, 0, 0, 0)
        val sortedArray = intArrayOf(0, 0, 0, 0, 0)

        selection.selectionSort(unsortedArray)
        assertArrayEquals(sortedArray, unsortedArray)
    }
}