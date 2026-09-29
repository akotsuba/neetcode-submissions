class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
        val expandQueue = ArrayDeque<IntArray>()

        val rows = grid.size
        val cols = grid[0].size

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] == 0) {
                    expandQueue.add(intArrayOf(i, j))
                }
            }
        }

        val dirs = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(0, 1),
        )

        while (expandQueue.size > 0) {
            val (r, c) = expandQueue.poll()

            for (dir in dirs) {
                val newR = r + dir[0]
                val newC = c + dir[1]

                if (newR in 0 until rows && newC in 0 until cols && grid[newR][newC] == Int.MAX_VALUE) {
                    grid[newR][newC] = grid[r][c] + 1
                    expandQueue.add(intArrayOf(newR, newC))
                }                
            }
        }
    }
}
