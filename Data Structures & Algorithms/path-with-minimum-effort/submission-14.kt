class Solution {
    fun minimumEffortPath(heights: Array<IntArray>): Int {

        

        fun canReach(maxEffort: Int) : Boolean {
            val rows = heights.size
            val cols = heights[0].size

            val dirs = arrayOf(
                arrayOf(1, 0),
                arrayOf(0, 1),
                arrayOf(-1, 0),
                arrayOf(0, -1),
            )

            val visited = Array(rows) { BooleanArray(cols) }
            val queue = ArrayDeque<IntArray>()
            queue.add(intArrayOf(0, 0))
            visited[0][0] = true

            while (queue.isNotEmpty()) {
                val (r, c) = queue.poll()

                if (r == rows - 1 && c == cols - 1) return true

                for (dir in dirs) {
                    val nr = r + dir[0]
                    val nc = c + dir[1]

                    if (nr in 0 until rows && nc in 0 until cols && !visited[nr][nc]) {
                        val diff = abs(heights[r][c] - heights[nr][nc])
                        if (diff <= maxEffort) {
                            visited[nr][nc] = true
                            queue.add(intArrayOf(nr, nc))
                        }
                    }
                }
            }

            return false
        }

        var l = 0
        var r = 1000000
        var result = r

        while (l <= r) {
            val m = l + (r - l) / 2

            if (canReach(m)) {
                result = m
                r = m - 1
            } else {
                l = m + 1
            }
        }

        return result
    }
}
