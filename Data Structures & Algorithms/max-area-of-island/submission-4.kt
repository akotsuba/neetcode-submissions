class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val dirs = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(0, 1),
        )

        val rows = grid.size
        val cols = grid[0].size

        var maxArea = 0

        fun dfs(r: Int, c: Int): Int {
            if (r !in 0 until rows) return 0
            if (c !in 0 until cols) return 0
            if (grid[r][c] == 0) return 0

            grid[r][c] = 0
            var area = 1

            for (dir in dirs) {
                val newR = r + dir[0]
                val newC = c + dir[1]

                area += dfs(newR, newC)
            }

            return area
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == 1) {
                    val curArea = dfs(r, c)
                    maxArea = max(maxArea, curArea)
                }
            }
        }

        return maxArea
    }
}
