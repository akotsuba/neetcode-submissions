class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val dirs = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(0, 1),
        )

        var freshCount = 0

        val queue = ArrayDeque<IntArray>()

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] == 1) {
                    freshCount++
                } else if (grid[i][j] == 2) {
                    queue.add(intArrayOf(i, j))
                }
            }
        }

        var time = 0

        if (freshCount == 0) return 0

        while (queue.isNotEmpty() && freshCount > 0) {
            repeat(queue.size) {
                val (r, c) = queue.poll()

                for (dir in dirs) {
                    val newR = r + dir[0]
                    val newC = c + dir[1]

                    if (newR in 0 until rows && newC in 0 until cols && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2
                        freshCount--
                        queue.add(intArrayOf(newR, newC))
                    }
                }
            }

            time++
        }

        return if (freshCount == 0) time else -1
    }
}
