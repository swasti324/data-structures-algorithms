import org.example.MaxHeapSort
import org.example.SelectionSort
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MaxHeapSortTest {
    val heap = MaxHeapSort()
    @Test
    fun heapTest1() {
        val unsortedArray = intArrayOf(64, 25, 12, 22, 11)
        val sortedArray = intArrayOf(11, 12, 22, 25, 64)
        heap.heapSort(unsortedArray)
        assertArrayEquals(sortedArray, unsortedArray)
    }
    @Test
    fun heapTest2() {
        val unsortedArray = intArrayOf(0, 0, 0, 0, 0)
        val sortedArray = intArrayOf(0, 0, 0, 0, 0)

        heap.heapSort(unsortedArray)
        assertArrayEquals(sortedArray, unsortedArray)
    }
}