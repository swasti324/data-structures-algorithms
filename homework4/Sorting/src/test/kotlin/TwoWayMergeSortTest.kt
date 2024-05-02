import org.example.TwoWayMergeSort
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TwoWayMergeSortTest {

    val merge = TwoWayMergeSort()
    @Test
    fun selectionTest1() {
        var unsortedArray = listOf(64, 25, 12, 22, 11)
        val sortedArray = listOf(11, 12, 22, 25, 64)
        print("hello" + unsortedArray)

        unsortedArray = merge.mergeSort(unsortedArray)
        print(unsortedArray)

        assertEquals(sortedArray, unsortedArray)
    }
    @Test
    fun selectionTest2() {
        val unsortedArray = listOf(0, 0, 0, 0, 0)
        val sortedArray = listOf(0, 0, 0, 0, 0)

        merge.mergeSort(unsortedArray)
        assertEquals(sortedArray, unsortedArray)
    }
}