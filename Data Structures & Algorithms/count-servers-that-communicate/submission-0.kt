class Solution {
    fun countServers(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size

        val countPerRow = IntArray(rows)
        val countPerCol = IntArray(cols)

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == 1) {
                    countPerRow[r]++
                    countPerCol[c]++
                }
            }
        }

        var result = 0
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == 1 && (countPerRow[r] > 1 || countPerCol[c] > 1)) {
                    result++
                }
            }
        }

        return result
    }
}
