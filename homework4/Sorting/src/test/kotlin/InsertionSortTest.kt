import org.example.InsertionSort

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class InsertionSortTest {
    private val insertion = InsertionSort()
    @Test
    fun insertionTest1() {
        val unsortedArray = intArrayOf(64, 25, 12, 22, 11)
        val sortedArray = intArrayOf(11, 12, 22, 25, 64)

        insertion.insertionSort(unsortedArray)
        assertArrayEquals(sortedArray, unsortedArray)
    }
    @Test
    fun insertionTest2() {
        val unsortedArray = intArrayOf(0, 0, 0, 0, 0)
        val sortedArray = intArrayOf(0, 0, 0, 0, 0)

        insertion.insertionSort(unsortedArray)
        assertArrayEquals(sortedArray, unsortedArray)
    }
}