class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val dirs = arrayOf(
            arrayOf(0, 1),
            arrayOf(1, 0),
            arrayOf(0, -1),
            arrayOf(-1, 0),
        )
        val rows = board.size
        val cols = board[0].size

        val rowsRange = 0 until rows
        val colsRange = 0 until cols

        fun backtrack(r: Int, c: Int, wordIndex: Int): Boolean {
            if (wordIndex == word.length) {
                return true
            }
            if (r !in rowsRange || c !in colsRange || word[wordIndex] != board[r][c]) {
                return false
            }

            val temp = board[r][c]
            board[r][c] = '#'

            for (dir in dirs) {
                val nr = r + dir[0]
                val nc = c + dir[1]

                if (backtrack(nr, nc, wordIndex + 1)) {
                    return true
                }
            }

            board[r][c] = temp

            return false
        }

        for (r in rowsRange) {
            for (c in colsRange) {
                if (backtrack(r, c, 0)) {
                    return true
                }
            }
        }

        return false
    }
}
