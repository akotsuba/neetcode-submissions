const val SAVED = 'S'

class Solution {
    // O(m * n)

    fun solve(board: Array<CharArray>) {
        val rows = board.size
        val cols = board[0].size

        val dirs = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(0, 1),
        )

        fun dfs(r: Int, c: Int) {
            if (board[r][c] != 'O') return

            board[r][c] = SAVED

            for (dir in dirs) {
                val newR = r + dir[0]
                val newC = c + dir[1]

                if (newR in 0 until rows && newC in 0 until cols) {
                    dfs(newR, newC)
                }
            }
        }

        for (r in 0 until rows) {
            // left, right
            if (board[r][0] == 'O') dfs(r, 0)
            if (board[r][cols - 1] == 'O') dfs(r, cols - 1)
        }

        for (c in 1 until cols - 1) {
            // top, bottom
            if (board[0][c] == 'O') dfs(0, c)
            if (board[rows - 1][c] == 'O') dfs(rows - 1, c)
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (board[r][c] == SAVED) board[r][c] = 'O'
                else if (board[r][c] == 'O') board[r][c] = 'X'
            }
        }
    }
}
