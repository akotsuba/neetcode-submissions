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

        fun bfs(r: Int, c: Int) {
            val q: Queue<IntArray> = LinkedList()
            grid[r][c] = '0'
            q.add(intArrayOf(r, c))

            while (q.isNotEmpty()) {
                val (row, col) = q.poll()

                for (dir in dirs) {
                    val rr = row + dir[0]
                    val cc = col + dir[1]

                    if (rr < 0 || cc < 0 || 
                        rr >= rows || cc >= cols || 
                        grid[rr][cc] == '0') {
                        continue
                    }

                    q.add(intArrayOf(rr, cc))
                    grid[rr][cc] = '0'
                }
            }

        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == '1') {
                    bfs(r, c)
                    islands++
                }
            }
        }

        return islands
    }
}
