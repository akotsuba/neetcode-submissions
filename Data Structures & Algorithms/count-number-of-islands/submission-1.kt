class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val dirs = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0),
        )

        val rows = grid.size
        val cols = grid[0].size
        var islands = 0
        
        fun dfs(r: Int, c: Int) {
            if (r < 0 || r > rows - 1) return
            if (c < 0 || c > cols - 1) return
            if (grid[r][c] == '0') return

            grid[r][c] = '0'

            for (dir in dirs) {
                dfs(r + dir[0], c + dir[1])
            }
        }

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] == '1') {
                    islands++
                    dfs(i, j)
                }
            }
        }

        return islands
    }
}
