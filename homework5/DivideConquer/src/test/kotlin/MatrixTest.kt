import org.example.Matrix
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MatrixTest {
    @Test
            /**
             * Tests setting and getting values in the matrix.
             */
    fun testSetValueAndGet() {
        // Initialize a 3x3 matrix
        val matrix = Matrix(3)

        // Set values at specific positions
        matrix.setValue(0, 0, 1)
        matrix.setValue(1, 1, 2)
        matrix.setValue(2, 2, 3)

        // Check if the set values are retrieved correctly
        assertEquals(1, matrix.getValue(0, 0))
        assertEquals(2, matrix.getValue(1, 1))
        assertEquals(3, matrix.getValue(2, 2))
    }

    @Test
            /**
             * Tests matrix multiplication.
             */
    fun testMultiply() {
        // Create two 2x2 matrices
        val matrix1 = Matrix(2).apply {
            setValue(0, 0, 1)
            setValue(0, 1, 2)
            setValue(1, 0, 3)
            setValue(1, 1, 4)
        }

        val matrix2 = Matrix(2).apply {
            setValue(0, 0, 5)
            setValue(0, 1, 6)
            setValue(1, 0, 7)
            setValue(1, 1, 8)
        }

        // Expected result of matrix multiplication
        val expectedResult = Matrix(2).apply {
            setValue(0, 0, 19)
            setValue(0, 1, 22)
            setValue(1, 0, 43)
            setValue(1, 1, 50)
        }

        // Perform matrix multiplication
        val result = matrix1.multiply(matrix2)

        // Check if the result matches the expected result
        assertArrayEquals(expectedResult.matrix, result!!.matrix)
    }

    @Test
            /**
             * Tests matrix multiplication using the Strassen algorithm.
             */
    fun testStrassenMultiply() {
        // Create two 2x2 matrices
        val matrix1 = Matrix(2).apply {
            setValue(0, 0, 1)
            setValue(0, 1, 2)
            setValue(1, 0, 3)
            setValue(1, 1, 4)
        }

        val matrix2 = Matrix(2).apply {
            setValue(0, 0, 5)
            setValue(0, 1, 6)
            setValue(1, 0, 7)
            setValue(1, 1, 8)
        }

        // Expected result of matrix multiplication
        val expectedResult = Matrix(2).apply {
            setValue(0, 0, 19)
            setValue(0, 1, 22)
            setValue(1, 0, 43)
            setValue(1, 1, 50)
        }

        // Perform matrix multiplication using Strassen algorithm
        val result = matrix1.strassen(matrix1, matrix2)

        // Check if the result matches the expected result
        assertArrayEquals(expectedResult.matrix, result!!.matrix)
    }

    @Test
            /**
             * Tests the Needleman-Wunsch algorithm for global sequence alignment.
             */
    fun testNeedlemanWunsch() {
        val matrix = Matrix(5)
        val sequence1 = "AGTACGCA"
        val sequence2 = "TATGC"

        val expectedAlignment1 = "TAT-G--C"
        val expectedAlignment2 = "--TATGC-"

        // Perform sequence alignment using Needleman-Wunsch algorithm
        val (alignedSeq1, alignedSeq2) = matrix.needlemanWunsch(sequence1, sequence2)

        // Check if the aligned sequences match the expected alignments
        assertEquals(expectedAlignment1, alignedSeq1)
        assertEquals(expectedAlignment2, alignedSeq2)
    }

}
