class Solution {
    fun maxProfit(prices: IntArray): Int {
        var l = 0
        
        var maxProfit = 0
        for (r in 1 until prices.size) {
            if (prices[r] < prices[l]) {
                l = r
            } else {
                maxProfit = maxOf(maxProfit, prices[r] - prices[l])
            }
        }

        return maxProfit
    }
}
