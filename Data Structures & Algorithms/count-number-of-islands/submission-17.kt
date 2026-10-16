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

        fun dfs(r: Int, c: Int) {
            if (r !in 0 until rows || c !in 0 until cols || grid[r][c] == '0') return 

            grid[r][c] = '0'

            for (dir in dirs) {
                val nr = r + dir[0]
                val nc = c + dir[1]

                dfs(nr, nc)
            }
        }

        fun bfs(r: Int, c: Int) {
            val queue = ArrayDeque<IntArray>()
            queue.add(intArrayOf(r, c))

            while (queue.isNotEmpty()) {
                val (r, c) = queue.removeLast()

                grid[r][c] = '0'

                for (dir in dirs) {
                    val nr = r + dir[0]
                    val nc = c + dir[1]

                    if (nr in 0 until rows && nc in 0 until cols && grid[nr][nc] != '0') {
                        queue.add(intArrayOf(nr, nc))
                    }
                }
            }
        }

        var numIsland = 0

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] == '1') {
                    numIsland++
                    bfs(i, j)
                }
            }
        }

        return numIsland
    }
}
