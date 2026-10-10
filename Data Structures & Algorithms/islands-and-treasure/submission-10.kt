class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
        val dirs = arrayOf(
            arrayOf(0, 1),
            arrayOf(1, 0),
            arrayOf(0, -1),
            arrayOf(-1, 0),
        )

        val rows = grid.size
        val cols = grid[0].size

        val queue = ArrayDeque<IntArray>()

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == 0) {
                    queue.add(intArrayOf(r, c))
                }
            }
        }

        // var curDistance = 0

        while (queue.isNotEmpty()) {
            // println("queue = $queue curDistance = $curDistance")

            // repeat(queue.size) {
                val (r, c) = queue.poll()

                // grid[r][c] = curDistance

                for (dir in dirs) {
                    val newR = r + dir[0]
                    val newC = c + dir[1]

                    if (newR in 0 until rows && 
                        newC in 0 until cols && 
                        grid[newR][newC] == Int.MAX_VALUE) {
                            grid[newR][newC] = grid[r][c] + 1
                            queue.add(intArrayOf(newR, newC))
                    }
                // }
            }

            // curDistance++
        }        
    }
}
