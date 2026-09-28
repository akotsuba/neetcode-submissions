class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.size == 0) return false

        val rows = matrix.size
        val cols = matrix[0].size

        var l = 0
        var r = rows * cols - 1

        while (l <= r) {
            val m = l + (r - l) / 2

            val i = m / cols
            val j = m % cols

            if (matrix[i][j] == target) {
                return true
            } else if (matrix[i][j] < target) {
                l = m + 1
            } else {
                r = m - 1
            }
        }

        return false
    }
}
