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
        var curArea = 0

        fun dfs(r: Int, c: Int) {
            if (r !in 0 until rows) return
            if (c !in 0 until cols) return
            if (grid[r][c] == 0) return

            grid[r][c] = 0
            curArea++

            for (dir in dirs) {
                val newR = r + dir[0]
                val newC = c + dir[1]

                dfs(newR, newC)
            }
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == 1) {
                    curArea = 0
                    dfs(r, c)

                    maxArea = max(maxArea, curArea)
                }
            }
        }

        return maxArea
    }
}
