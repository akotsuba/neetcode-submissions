class Solution {
    /* 1. Bruteforce, top-down
        O(2^n)

    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2

        return climbStairs(n - 1) + climbStairs(n - 2)
    }
    */

    /* 2. Bruteforce + memo, top-down
        O(n) + O(n)

    private val memo = HashMap<Int, Int>()

    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2

        if (memo.contains(n)) return memo[n]!!

        val result = climbStairs(n - 1) + climbStairs(n - 2)

        return result
    }
    */

    /* 3. Bottom-up
        O(n) + O(n)

    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2

        val dp = IntArray(n + 1)
        dp[1] = 1
        dp[2] = 2

        for (i in 3..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        return dp[n]
    }
    */

    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2

        var dp1 = 1
        var dp2 = 2

        for (i in 3..n) {
            val temp = dp2
            dp2 = dp1 + dp2
            dp1 = temp
        }

        return dp2
    }
}
