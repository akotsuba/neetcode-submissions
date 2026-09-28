class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        val rows = matrix.size
        val cols = matrix[0].size

        var row0 = matrix[0][0]

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0

                    if (i == 0) {
                        row0 = 0
                    } else {
                        matrix[i][0] = 0
                    }
                }
            }
        }

        for (i in 1 until rows) {
            if (matrix[i][0] == 0) {
               for (j in 1 until cols) {
                    matrix[i][j] = 0
               }     
            }
        }

        for (j in 0 until cols) {
            if (matrix[0][j] == 0) {
                for (i in 1 until rows) {
                    matrix[i][j] = 0
                }
            }
        }

        if (row0 == 0) {
            for (j in 0 until cols) {
                matrix[0][j] = 0
            }
        }
    }
}
