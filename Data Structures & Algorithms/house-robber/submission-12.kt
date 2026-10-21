class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) return 0
        if (n == 1) return nums[0]

        val dp = IntArray(n) // max to rob from 0 to i
        var dp2 = nums[0]
        var dp1 = maxOf(nums[0], nums[1])

        for (i in 2 until n) {
            val rob = nums[i] + dp2
            val skip = dp1

            val temp = dp1
            dp1 = maxOf(rob, skip)
            dp2 = temp
        }

        return dp1
    }
}
