class Solution {
    fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
        val n = grid.size

        var duplicates = 0

        for (i in 0 until n) {
            for (j in 0 until n) {
                val value = abs(grid[i][j])
                val r = (value - 1) / n
                val c = (value - 1) % n

                if (grid[r][c] > 0) {
                    grid[r][c] = -grid[r][c]
                } else {
                    duplicates = value
                }
            }
        }

        var missing = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (grid[i][j] > 0) {
                    missing = i * n + j + 1
                }
            }
        }

        return intArrayOf(duplicates, missing)
    }
}