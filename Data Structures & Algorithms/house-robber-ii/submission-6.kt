class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) return 0
        if (n == 1) return nums[0]

        fun getMaxRob(start: Int, end: Int): Int {
            var prev1 = 0
            var prev2 = 0

            for (i in start..end) {
                val skip = prev1
                val rob = nums[i] + prev2

                val temp = prev1
                prev1 = maxOf(skip, rob)
                prev2 = temp
            }

            return prev1
        }

        return maxOf(
            getMaxRob(0, n - 2),
            getMaxRob(1, n - 1),
        )
    }
}
