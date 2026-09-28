class Solution {

    /* 1. Bruteforce, Top-down, O(2^n)

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

    // 2 Bruteforce + memo, Top-down

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
}
