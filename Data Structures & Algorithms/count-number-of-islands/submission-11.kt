class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val dirs = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1),
            intArrayOf(-1, 0),
            intArrayOf(0, -1),
        )
        val rows = grid.size
        val cols = grid[0].size

        var islands = 0

        fun dfs(i: Int, j: Int) {
            if (i !in 0 until rows || j !in 0 until cols) return
            if (grid[i][j] == '0') return 

            grid[i][j] = '0'

            for (dir in dirs) {
                val newI = i + dir[0]
                val newJ = j + dir[1]

                dfs(newI, newJ)
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
