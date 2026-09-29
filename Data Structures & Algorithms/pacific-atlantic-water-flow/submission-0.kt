class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val rows = heights.size
        val cols = heights[0].size

        val pacific = Array(rows) { BooleanArray(cols) }
        val atlantic = Array(rows) { BooleanArray(cols) }

        var result = mutableListOf<List<Int>>()

        val dirs = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(0, 1),
        )

        fun dfs(r: Int, c: Int, visits: Array<BooleanArray>) {
            // if (r !in 0 until rows) return
            // if (c !in 0 until cols) return
            if (visits[r][c]) return 

            visits[r][c] = true

            for (dir in dirs) {
                val newR = r + dir[0]
                val newC = c + dir[1]

                if (newR in 0 until rows && newC in 0 until cols && heights[newR][newC] >= heights[r][c]) {
                    dfs(newR, newC, visits)
                }
            }
        }

        // top + bottom
        for (c in 0 until cols) {
            dfs(0, c, pacific)
            dfs(rows - 1, c, atlantic)
        }

        // left + right
        for (r in 0 until rows) {
            dfs(r, 0, pacific)
            dfs(r, cols - 1, atlantic)
        }

        // merge results
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(listOf(r, c))
                }
            }
        }

        return result
    }
}
