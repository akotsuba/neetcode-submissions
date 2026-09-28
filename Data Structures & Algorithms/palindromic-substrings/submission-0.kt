class Solution {

    /* Bottom-up
        diagonal
        to the right
        up
        to the right...
    */

    fun countSubstrings(s: String): Int {
        var count = 0

        val n = s.length
        val dp = Array(n) { BooleanArray(n) }

        for (i in n - 1 downTo 0) {
            for (j in i until n) {
                if (s[i] == s[j]) {
                    val length = j - i + 1
                    
                    if (length <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true
                        count++
                    }  
                }
            }
        }

        return count
    }
}
