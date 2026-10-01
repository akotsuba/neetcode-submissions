class Solution {
    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size

        val time = Array(n) { Array(n) { Int.MAX_VALUE } }
        time[0][0] = grid[0][0]

        val dirs = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(0, 1),
        )

        val pq = PriorityQueue<IntArray>(compareBy { it[2] })
        pq.add(intArrayOf(0, 0, grid[0][0]))

        while (pq.isNotEmpty()) {
            val (r, c, t) = pq.poll()

            if (r == n - 1 && c == n - 1) return t

            // skip outdated ones
            if (t > time[r][c]) continue

            for (dir in dirs) {
                val nr = r + dir[0]
                val nc = c + dir[1]

                if (nr in 0 until n && nc in 0 until n) {
                    val nt = max(grid[nr][nc], t)

                    if (nt < time[nr][nc]) {
                        time[nr][nc] = nt
                        pq.add(intArrayOf(nr, nc, nt))
                    }
                }
            }
        }

        return 0
    }
}
