class Solution {

    data class State(
        val effort: Int,
        val row: Int, 
        val col: Int,
    )

    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val rows = heights.size
        val cols = heights[0].size

        val dirs = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1),
            intArrayOf(-1, 0),
            intArrayOf(0, -1),
        )

        val efforts = Array(rows) { IntArray(cols) { Int.MAX_VALUE } } 
        efforts[0][0] = 0

        val pq = PriorityQueue<State>( compareBy { it.effort })
        pq.offer(State(0, 0, 0))

        while (pq.isNotEmpty()) {
            val (curEffort, r, c) = pq.poll()

            if (r == rows - 1 && c == cols - 1) return curEffort

            if (curEffort > efforts[r][c]) continue

            for (dir in dirs) {
                val nr = r + dir[0]
                val nc = c + dir[1]

                if (nr !in 0 until rows || nc !in 0 until cols) continue

                val diff = abs(heights[r][c] - heights[nr][nc])

                val newEffort = maxOf(curEffort, diff)

                if (newEffort < efforts[nr][nc]) {
                    efforts[nr][nc] = newEffort
                    pq.offer(State(newEffort, nr, nc))
                }
            }
        }

        return 0
    }
}
