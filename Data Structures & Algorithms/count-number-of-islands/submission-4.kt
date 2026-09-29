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

        fun bfs(r: Int, c: Int) {
            val queue = ArrayDeque<IntArray>()
            queue.add(intArrayOf(r, c))
            grid[r][c] = '0'
            
            while (queue.isNotEmpty()) {
                val (curR, curC) = queue.poll()
                
                for (dir in dirs) {
                    val newR = curR + dir[0]
                    val newC = curC + dir[1]

                    if (newR in 0 until rows && newC in 0 until cols && grid[newR][newC] == '1') {
                        queue.add(intArrayOf(newR, newC))
                        grid[newR][newC] = '0'
                    }
                }
            }
        }

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] == '1') {
                    islands++
                    // dfs(i, j)
                    bfs(i, j)
                }
            }
        }

        return islands
    }
}
