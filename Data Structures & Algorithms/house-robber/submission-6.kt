class Solution {
    
    fun rob(nums: IntArray): Int {
        if (nums.size == 0) return 0
        if (nums.size == 1) return nums[0]

        val dp = IntArray(nums.size)

        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for (i in 2..nums.size - 1) {
            dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])
        }

        return dp[nums.size - 1]
    }
}
