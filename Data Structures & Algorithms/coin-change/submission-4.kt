class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0

        for (i in 1..amount) {
            for (coin in coins) {
                if (coin > i) continue

                val remain = i - coin
                dp[i] = minOf(dp[i], dp[remain] + 1)
            }
        }

        return if (dp[amount] != amount + 1) dp[amount] else -1
    }
}
