class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) return 0
        if (n == 1) return nums[0]

        val dp = IntArray(n) // max to rob from 0 to i
        dp[0] = nums[0]
        dp[1] = maxOf(nums[0], nums[1])

        for (i in 2 until n) {
            val rob = nums[i] + dp[i - 2]
            val skip = dp[i - 1]

            dp[i] = maxOf(rob, skip)
        }

        return dp[n - 1]
    }
}
