class Solution {
    // Bruteforce: O(n^3)
    // + memo: O(n^2) + O(n^2)

    // Bottom-up

    /*
       1. By substring length. length = 2..s.length
        length = 1: set to true (i == j)
        length = 2: compare s[i] and s[j]
        length > 2: compare s[i] and s[j] + check s[i+1] and s[j-1]    

         0 1 2 3
       0 t
       1   t 
       2     t
       3       t 

       2. Bottom-top 
        Start from bottom right, compare and set (diagonals are always true)
        Shift to top + right (another diagonal), move left to right
        Fill accordingly because bottom ones are filled already
        DO NOT forget to check if len <= 2 (len = j - i + 1)
    */

    fun isPalindrome(s: String, i: Int, j: Int): Boolean {
        if (i <= j) return true
        if (s[i] != s[j]) return false

        return isPalindrome(s, i + 1, j - 1)
    }

    fun longestPalindrome(s: String): String {
        val n = s.length
        if (n < 2) return s

        val dp = Array(n) { BooleanArray(n) }
        var maxLenStart = 0
        var maxLen = 1

        for (l in 1..n) {
            for (i in 0..n - l) {    // IMPORTANT! n - l
                val j = i + l - 1

                if (l == 1)  {
                    dp[i][j] = true
                } else if (s[i] == s[j]) {
                    if (l == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true

                        if (l > maxLen) {
                            maxLen = l
                            maxLenStart = i
                        }
                    }
                }
            }
        }

        return s.substring(maxLenStart, maxLenStart + maxLen)
    }
}
