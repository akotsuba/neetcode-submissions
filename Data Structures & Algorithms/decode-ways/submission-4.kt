class Solution {
    /*  Bruteforce O(2^n)
        + memo O(n) / O(n)

    fun numDecodings(s: String): Int {
        val len = s.length

        val memo = IntArray(len) { -1 }

        fun dfs(i: Int): Int {
            if (i >= len) return 1
            if (s[i] == '0') return 0
            if (memo[i] != -1) return memo[i]!!

            var result = dfs(i + 1)

            if (i < len - 1) {
                val digit = s.substring(i, i + 2).toInt()
                if (digit in 10..26) {
                    result += dfs(i + 2)
                }
            }

            memo[i] = result

            return result
        }

        return dfs(0)
    }

    */

    fun numDecodings(s: String): Int {
        if (s.length == 0 || s[0] == '0') return 0
        
        val n = s.length

        var prev1 = 1
        var prev2 = 1

        for (i in 1 until n) {
            val digitOne = s[i] - '0'
            val digitTwo = (s[i - 1] - '0') * 10 + digitOne

            var current = 0

            if (digitOne in 1..9) {
                current += prev1
            }

            if (digitTwo in 10..26) {
                current += prev2
            }

            prev2 = prev1
            prev1 = current
        }

        return prev1
    }
}
