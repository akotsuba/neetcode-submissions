class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val size = matrix.size
        
        var l = 0
        var r = size - 1
        var t = 0
        var b = size - 1

        while (r > l) {
            val size = r - l

            for (i in 0 until size) {
                val temp = matrix[t][l + i]
                
                matrix[t][l + i] = matrix[b - i][l]
                matrix[b - i][l] = matrix[b][r - i]
                matrix[b][r - i] = matrix[t + i][r]
                matrix[t + i][r] = temp
            }

            l++
            r--
            t++
            b--
        }
    }
}
