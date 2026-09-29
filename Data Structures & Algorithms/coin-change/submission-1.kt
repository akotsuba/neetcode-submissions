class Solution {
    /* Bruteforce + memo
    
    fun coinChange(coins: IntArray, amount: Int): Int {

        val memo = IntArray(amount + 1) { -2 }

        fun dfs(remain: Int): Int {
            if (remain < 0) return -1
            if (remain == 0) return 0
            if (memo.contains(remain)) return memo[remain]!!

            var minCount = Int.MAX_VALUE

            for (coin in coins) {
                val result = dfs(remain - coin)

                if (result != -1) {
                    minCount = min(minCount, result + 1)
                }
            }

            memo[remain] = if (minCount == Int.MAX_VALUE) -1 else minCount

            println("remain = $remain minCount = ${memo[remain]}")

            return memo[remain]
        }

        return dfs(amount)  
    }

    */

    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { amount + 1 }

        dp[0] = 0

        for (i in 1..amount) {
            for (coin in coins) {
                val remain = i - coin
                if (remain >= 0) {
                    // compare the value which could be already calculated before for another coin
                    // with the solution for 'remain' plus current coin
                    dp[i] = min(dp[remain] + 1, dp[i]) 
                }
            }
        }

        return if (dp[amount] == amount + 1) -1 else dp[amount]
    }
}
