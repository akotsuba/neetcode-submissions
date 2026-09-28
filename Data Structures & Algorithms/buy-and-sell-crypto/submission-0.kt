class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) return 0
        var result = 0

        var buyPrice = prices[0]

        for (i in 1..prices.size - 1) {
            val currentPrice = prices[i]

            if (currentPrice < buyPrice) {
                buyPrice = currentPrice
            } else {
                val diff = currentPrice - buyPrice
                result = max(result, diff)
            }
        }

        return result
    }
}
