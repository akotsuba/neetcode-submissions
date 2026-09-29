class Solution {
    fun maxProduct(nums: IntArray): Int {
        val n = nums.size
        val minDp = IntArray(n)
        val maxDp = IntArray(n)

        minDp[0] = nums[0]
        maxDp[0] = nums[0]

        var totalMax = maxDp[0]

        for (i in 1 until n) {
            val op1 = nums[i]
            val op2 = nums[i] * minDp[i - 1]
            val op3 = nums[i] * maxDp[i - 1]

            val curMin = minOf(op1, op2, op3)
            val curMax = maxOf(op1, op2, op3)

            minDp[i] = curMin
            maxDp[i] = curMax

            if (curMax > totalMax) {
                totalMax = curMax
            }
        }

        return totalMax
    }
}
