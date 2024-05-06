package org.example
class Matrix(private val size: Int) {
    val matrix: Array<IntArray> = Array(size) { IntArray(size) }
    override fun toString(): String {
        val sb = StringBuilder()
        for (row in matrix) {
            sb.append(row.joinToString(" ") { it.toString() })
            sb.append("\n")
        }
        return sb.toString()
    }

    fun setValue(row: Int, col: Int, value: Int) {
        /*
        This sets the value of a given row and column

        Args:
            Row - int
            col - int
            value - int

        Returns:
        nothing, but updates the matrix
         */
        matrix[row][col] = value
    }

    fun getValue(row: Int, col: Int): Int {
        /*
       This outputs the value of a given row and column

       Args:
           Row - int
           col - int

       Returns:
            the value stored in the matrix
       */
        return matrix[row][col]
    }

    fun multiply(other: Matrix): Matrix? {
        /*
        This performs a regular Matrix multiplication operation
        it will check for the matrix being
       Args:
           Row - int
           col - int
           value - int

       Returns:
       nothing, but updates the matrix
        */
        if (size != other.size) return null // Check if dimensions are compatible

        val result = Matrix(size)

        for (i in 0 until size) {
            for (j in 0 until size) {
                var sum = 0
                for (k in 0 until size) {
                    sum += matrix[i][k] * other.matrix[k][j]
                }
                result.setValue(i, j, sum)
            }
        }

        return result
    }

    // Strassen multiplication
    /*
   This performs matrix multiplication using the Strassen algorithm with another matrix.

   Args:
       other - The matrix to multiply with.

   Returns:
       The result of matrix multiplication if dimensions are compatible, null otherwise.
    */
    fun strassen(a: Matrix, b: Matrix): Matrix {
        // Check if the matrices are square and have the same dimensions.

        if (a.size != a.size || b.size != b.size || a.size != b.size) {
            throw IllegalArgumentException("Matrices must be square and have the same dimensions.")
        }

        // If the matrices are small enough, use the naive algorithm.
        if (a.size <= 2) {
            return a.multiply(b) ?: throw IllegalStateException("Multiplication result is null.")
        }

        // Divide the matrices into four submatrices.
        val a11 = a.submatrix(0, a.size / 2, 0, a.size / 2)
        val a12 = a.submatrix(0, a.size / 2, a.size / 2, a.size)
        val a21 = a.submatrix(a.size / 2, a.size, 0, a.size / 2)
        val a22 = a.submatrix(a.size / 2, a.size, a.size / 2, a.size)
        val b11 = b.submatrix(0, b.size / 2, 0, b.size / 2)
        val b12 = b.submatrix(0, b.size / 2, b.size / 2, b.size)
        val b21 = b.submatrix(b.size / 2, b.size, 0, b.size / 2)
        val b22 = b.submatrix(b.size / 2, b.size, b.size / 2, b.size)

        // Compute the seven subproblems.
        val p1 = strassen(a11.add(a22), b11.add(b22))
        val p2 = strassen(a21.add(a22), b11)
        val p3 = strassen(a11, b12.subtract(b22))
        val p4 = strassen(a22, b21.subtract(b11))
        val p5 = strassen(a11.add(a12), b22)
        val p6 = strassen(a21.subtract(a11), b11.add(b12))
        val p7 = strassen(a12.subtract(a22), b21.add(b22))

        // Combine the subproblems to form the result matrix.
        val c11 = p1.add(p4).subtract(p5).add(p7)
        val c12 = p3.add(p5)
        val c21 = p2.add(p4)
        val c22 = p1.add(p3).subtract(p2).add(p6)

        // Combine the submatrices into the result matrix.
        val result = Matrix(a.size)
        result.joinSubmatrices(c11, c12, c21, c22)

        return result
    }

    /*
      Extracts a submatrix from the current matrix.

     Args:
        startRow The starting row index of the submatrix (inclusive).
        endRow The ending row index of the submatrix (exclusive).
        startCol The starting column index of the submatrix (inclusive).
        endCol The ending column index of the submatrix (exclusive).
      Return:
       The submatrix extracted from the current matrix.
     */
    private fun submatrix(startRow: Int, endRow: Int, startCol: Int, endCol: Int): Matrix {
        val subSize = endRow - startRow
        val submatrix = Matrix(subSize)

        for (i in 0 until subSize) {
            for (j in 0 until subSize) {
                submatrix.setValue(i, j, matrix[startRow + i][startCol + j])
            }
        }
        return submatrix
    }

    /*
      Joins four submatrices into the current matrix.

      Args:
        c11 The top-left submatrix.
        c12 The top-right submatrix.
        c21 The bottom-left submatrix.
        c22 The bottom-right submatrix.
     */
    private fun joinSubmatrices(c11: Matrix, c12: Matrix, c21: Matrix, c22: Matrix) {
        val subSize = c11.size
        for (i in 0 until subSize) {
            for (j in 0 until subSize) {
                matrix[i][j] = c11.getValue(i, j)
                matrix[i][j + subSize] = c12.getValue(i, j)
                matrix[i + subSize][j] = c21.getValue(i, j)
                matrix[i + subSize][j + subSize] = c22.getValue(i, j)
            }
        }
    }

    /*
      Adds another matrix to the current matrix.

     Args:
      other The matrix to add.
     Returns:
        The result of matrix addition.
     */
    private fun add(other: Matrix): Matrix {
        val result = Matrix(size)
        for (i in 0 until size) {
            for (j in 0 until size) {
                result.setValue(i, j, matrix[i][j] + other.matrix[i][j])
            }
        }
        return result
    }

    /*
     Subtracts another matrix from the current matrix.

      Args:
       other The matrix to subtract.
      Return:
       The result of matrix subtraction.
     */
    private fun subtract(other: Matrix): Matrix {
        val result = Matrix(size)
        for (i in 0 until size) {
            for (j in 0 until size) {
                result.setValue(i, j, matrix[i][j] - other.matrix[i][j])
            }
        }
        return result
    }

    enum class Direction {
        /*
         Enumeration representing directions for traceback in sequence alignment.
         */
        DIAGONAL, LEFT, UP
    }


    /*
          Performs global sequence alignment using the Needleman-Wunsch algorithm.

          Args:
            sequence1 The first sequence to be aligned.
            sequence2 The second sequence to be aligned.
            matchScore The score for matching characters.
            mismatchScore The score for mismatching characters.
            gapPenalty The penalty for introducing a gap in the alignment.
          Returns:
            A Pair of aligned sequences representing the optimal alignment.
         */
    fun needlemanWunsch(
        sequence1: String,
        sequence2: String,
        matchScore: Int = 1,
        mismatchScore: Int = -1,
        gapPenalty: Int = -1
    ): Pair<String, String> {

        // Length of sequences
        val n = sequence1.length
        val m = sequence2.length


        // Initialize the alignment matrix and traceback matrix
        val alignmentMatrix = Array(n + 1) { IntArray(m + 1) }
        val tracebackMatrix = Array(n + 1) { Array<Direction>(m + 1) { Direction.DIAGONAL } }

        // Initialize the first row and first column of the alignment matrix
        for (i in 1..n) {
            alignmentMatrix[i][0] = i * gapPenalty
        }
        for (j in 1..m) {
            alignmentMatrix[0][j] = j * gapPenalty
        }

        // Fill in the alignment matrix and traceback matrix
        for (i in 1..n) {
            for (j in 1..m) {
                val match = if (sequence1[i - 1] == sequence2[j - 1]) matchScore else mismatchScore
                val diagonalScore = alignmentMatrix[i - 1][j - 1] + match
                val leftScore = alignmentMatrix[i][j - 1] + gapPenalty
                val upScore = alignmentMatrix[i - 1][j] + gapPenalty

                val maxScore = maxOf(diagonalScore, leftScore, upScore)

                alignmentMatrix[i][j] = maxScore

                // Determine the direction for traceback
                tracebackMatrix[i][j] = when {
                    maxScore == diagonalScore -> Direction.DIAGONAL
                    maxScore == leftScore -> Direction.LEFT
                    else -> Direction.UP
                }
            }
        }

        // Backtrace to generate the aligned sequences
        var i = n
        var j = m
        val alignedSequence1 = StringBuilder()
        val alignedSequence2 = StringBuilder()

        while (i > 0 || j > 0) {
            when (tracebackMatrix[i][j]) {
                Direction.DIAGONAL -> {
                    alignedSequence1.append(if (i > 0) sequence1[--i] else '-')
                    alignedSequence2.append(if (j > 0) sequence2[--j] else '-')
                }
                Direction.LEFT -> {
                    alignedSequence1.append('-')
                    alignedSequence2.append(sequence2[--j])
                }
                Direction.UP -> {
                    alignedSequence1.append(sequence1[--i])
                    alignedSequence2.append('-')
                }
            }
        }
        println("Alignment Matrix:")
        for (row in alignmentMatrix) {
            println(row.joinToString(" "))
        }

        println("Traceback Matrix:")
        for (row in tracebackMatrix) {
            println(row.joinToString(" ") { it.toString() })
        }

        println("Aligned Sequence 1: $alignedSequence1")
        println("Aligned Sequence 2: $alignedSequence2")


        return Pair(alignedSequence1.reverse().toString(), alignedSequence2.reverse().toString())
    }

}




