class Solution {
    // dfs: O(m * n) / O(m * n)
    // bfs: O(m * n) / O(m * n)

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

        fun dfs(i: Int, j: Int) {
            if (i !in 0 until rows) return 
            if (j !in 0 until cols) return 
            if (grid[i][j] == '0') return

            grid[i][j] = '0'

            for (dir in dirs) {
                dfs(i + dir[0], j + dir[1])
            }
        }

        fun bfs(i: Int, j: Int) {
            val queue = ArrayDeque<IntArray>()
            queue.add(intArrayOf(i, j))

            while (queue.isNotEmpty()) {
                val (i, j) = queue.removeLast()
                grid[i][j] = '0'

                for (dir in dirs) {
                    val newR = i + dir[0]
                    val newC = j + dir[1]

                    if (newR in 0 until rows && newC in 0 until cols && grid[newR][newC] == '1') {
                        queue.add(intArrayOf(newR, newC))
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
