class Solution {
    /* Top-bottom + memo O(2^n) -> O(n)

    fun maxProfit(prices: IntArray): Int {

        val memo = HashMap<Pair<Int, Boolean>, Int>()
        
        fun dfs(i: Int, hold: Boolean): Int {
            if (i == prices.size) return 0
            if (memo.contains(i to hold)) return memo[i to hold]!!

            if (hold) {
                // either sell or hold further
                val sell = prices[i] + dfs(i + 1, false)
                val holdProfit = dfs(i + 1, true)
                val max = max(sell, holdProfit)
                memo[i to hold] = max

                return max
            } else {
                // either buy or skip
                val buy = -prices[i] + dfs(i + 1, true)
                val skip = dfs(i + 1, false)
                val max = max(buy, skip)
                memo[i to hold] = max

                return max
            }
        }

        return dfs(0, false)
    }
    */

    // Bottom-top

    fun maxProfit(prices: IntArray): Int {
        var free = 0
        var hold = -prices[0]

        for (i in 0 until prices.size) {
            val newFree = max(free, hold + prices[i])
            val newHold = max(hold, free - prices[i])

            free = newFree
            hold = newHold
        }

        return free
    }
}
