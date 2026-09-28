class Solution {

    /* 1. Bruteforce, Top-down
        O(2^n)

    fun minCostClimbingStairs(cost: IntArray): Int {
        
        fun minCost(i: Int): Int {
            if (i <= 1) return 0

            val op1 = minCost(i - 1) + cost[i - 1]
            val op2 = minCost(i - 2) + cost[i - 2]

            return minOf(op1, op2)
        }

        return minCost(cost.size)
    }

    */

    /* 2 Bruteforce + memo, Top-down
        O(n), O(n)

    fun minCostClimbingStairs(cost: IntArray): Int {

        val memo = HashMap<Int, Int>()
        
        fun minCost(i: Int): Int {
            if (i <= 1) return 0
            if (memo.contains(i)) return memo[i]!!

            val op1 = minCost(i - 1) + cost[i - 1]
            val op2 = minCost(i - 2) + cost[i - 2]

            val price = minOf(op1, op2)
            memo[i] = price

            return price
        }

        return minCost(cost.size)
    }
    */

    /* Bottom-up 
        O(n), O(n)

    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size
        val dp = IntArray(n + 1)

        dp[0] = 0
        dp[1] = 0

        for (i in 2..n) {
            dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
        }

        return dp[n]
    }
    */

    // Bottom-up + memory optimization
    //    O(n), O(1)

    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size

        var dp0 = 0
        var dp1 = 0

        for (i in 2..n) {
            val temp = dp1
            dp1 = min(dp1 + cost[i - 1], dp0 + cost[i - 2])
            dp0 = temp
        }

        return dp1
    }
}
