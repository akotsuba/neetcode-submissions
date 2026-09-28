class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var result = mutableListOf<Int>()

        var l = 0
        var r = matrix[0].size
        var t = 0 
        var b = matrix.size

        while (l < r && t < b) {
            for (j in l until r) {
                result.add(matrix[t][j])
            }
            t++

            for (i in t until b) {
                result.add(matrix[i][r - 1])
            }
            r--

            if (!(l < r && t < b)) break

            for (j in r - 1 downTo l) {
                result.add(matrix[b - 1][j])
            }
            b--

            for (i in b - 1 downTo t) {
                result.add(matrix[i][l])
            }
            l++
        }

        return result
    }
}
