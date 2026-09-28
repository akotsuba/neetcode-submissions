class Solution {
    /*  Bruteforce O(2^n)
        + memo O(n) / O(n)
        Bottom-up
    */

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
}
