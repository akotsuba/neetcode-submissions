class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val dirs = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0),
        )
        val rows = grid.size
        val cols = grid[0].size

        fun dfs(r: Int, c: Int): Int {
            if (r !in 0 until rows || c !in 0 until cols || grid[r][c] == 0) return 0

             grid[r][c] = 0

             var size = 1
             for (dir in dirs) {
                val newR = r + dir[0]
                val newC = c + dir[1]

                size += dfs(newR, newC)
             }

             return size
        }

        var maxArea = 0
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == 1) {
                    maxArea = maxOf(maxArea, dfs(r, c))
                }
            }
        }

        return maxArea
    }
}
