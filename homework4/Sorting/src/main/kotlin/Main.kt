package org.example

import java.util.*
import kotlin.math.pow
import kotlin.time.measureTime

fun main() {
    val insertion = InsertionSort()
    val selection = SelectionSort()
    val heap = MaxHeapSort()
    val merge = TwoWayMergeSort()
    val insertionlist = mutableListOf<Float>()
    val selectionlist = mutableListOf<Float>()
    val heaplist = mutableListOf<Float>()
    val mergelist = mutableListOf<Float>()


    for (i in 0 until 20) {
        val randarr = IntArray((2.0.pow(i)).toInt())
        val random = Random()
        for(j in 0 until randarr.size)
        {
            randarr[j] = random.nextInt(10000)
        }
        val timeTakenInsert = measureTime {
            insertion.insertionSort(randarr)
        }
        val timeTakenSelection = measureTime {
            selection.selectionSort(randarr)
        }
        val timeTakenHeap = measureTime {
            heap.heapSort(randarr)
        }
        val timeTakenMerge = measureTime {
            merge.mergeSort(randarr.toList())
        }

        val InsertTimes: Float = timeTakenInsert.inWholeNanoseconds.toFloat() / 1000f
        insertionlist.add(InsertTimes)

        val SelectionTimes: Float = timeTakenSelection.inWholeNanoseconds.toFloat() / 1000f
        selectionlist.add(SelectionTimes)

        val HeapTimes: Float = timeTakenHeap.inWholeNanoseconds.toFloat() / 1000f
        heaplist.add(HeapTimes)

        val MergeTimes: Float = timeTakenMerge.inWholeNanoseconds.toFloat() / 1000f
        mergelist.add(MergeTimes)

    }
    println("Insertion Sort time " + insertionlist)
    println("Selection Sort time " + selectionlist)
    println("Heap Sort time " + heaplist)
    println("Merge Sort time " + mergelist)


}