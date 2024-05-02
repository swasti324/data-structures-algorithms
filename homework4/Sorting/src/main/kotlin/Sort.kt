package org.example


class InsertionSort(){
        fun insertionSort(arr: IntArray) {
            val n = arr.size
            for (i in 1 until n) {
                val key = arr[i]
                var j = i - 1

                // Move elements of arr[0..i-1] that are greater than key
                // to one position ahead of their current position
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j]
                    j--
                }
                arr[j + 1] = key
            }
      }
}

class SelectionSort(){
    fun selectionSort(arr: IntArray) {
        val n = arr.size
        for (i in 0 until n - 1) {
            var minIndex = i
            for (j in i + 1 until n) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j
                }
            }
            // Swap arr[minIndex] with arr[i]
            val temp = arr[minIndex]
            arr[minIndex] = arr[i]
            arr[i] = temp
        }
    }
}
public class MaxHeapSort {
    fun heapSort(array: IntArray): MutableList<Int> {

        val size = array.size
        val newArray = mutableListOf<Int>()

        var heapSize = size
        while (heapSize > 1) {
            // Build max heap
            buildMaxHeap(array, heapSize)
            // Swap root (max element) with the last element
            swap(array, 0, heapSize - 1)
            // Decrease heap size
            heapSize--
        }

        // Copy elements from array to newArray
        for (element in array) {
            newArray.add(element)
        }

        return newArray
    }

    private fun buildMaxHeap(array: IntArray, heapSize: Int) {
        for (i in heapSize / 2 - 1 downTo 0) {
            percolateDown(array, i, heapSize)
        }
    }

    private fun percolateDown(array: IntArray, index: Int, heapSize: Int) {
        var largest = index
        val left = 2 * index + 1
        val right = 2 * index + 2

        if (left < heapSize && array[left] > array[largest]) {
            largest = left
        }

        if (right < heapSize && array[right] > array[largest]) {
            largest = right
        }

        if (largest != index) {
            swap(array, index, largest)
            percolateDown(array, largest, heapSize)
        }
    }

    private fun swap(array: IntArray, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
}



class TwoWayMergeSort {
    fun mergeSort(unsorted: List<Int>): List<Int> {
//        split
        if (unsorted.size <= 1) {
            return unsorted
        }
        val split = unsorted.size / 2
        val leftSide = mergeSort(unsorted.slice(0 until split))
        val rightSide = mergeSort(unsorted.slice(split until unsorted.size))

        return merge(leftSide, rightSide)
    }

    private fun merge(listA: List<Int>, listB: List<Int>): List<Int> {
        val sizeA = listA.size
        val sizeB = listB.size
        var i = 0
        var j = 0
        val listC = mutableListOf<Int>()

        while (i < sizeA && j < sizeB) {
            if (listA[i] < listB[j]) {
                listC.add(listA[i])
                i++
            } else {
                listC.add(listB[j])
                j++
            }
        }
        while (i < sizeA) {
            listC.add(listA[i])
            i++
        }
        while (j < sizeB) {
            listC.add(listB[j])
            j++
        }
        return listC
    }
}

