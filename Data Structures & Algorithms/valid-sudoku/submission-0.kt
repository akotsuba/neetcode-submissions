class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) { HashSet<Char>() }
        val cols = Array(9) { HashSet<Char>() }
        val squares = Array(9) { HashSet<Char>() }

        for (j in 0..8) {
            val row = board[j]
            for (i in 0..8) {
                val item = row[i]
                if (item == '.') continue

                val squareIndex = (i / 3) * 3 + j / 3
                if (rows[i].contains(item) || 
                    cols[j].contains(item) || 
                    squares[squareIndex].contains(item)) {
                        return false
                    }

                rows[i].add(item)
                cols[j].add(item)
                squares[squareIndex].add(item)
            }
        }

        return true
    }
}
