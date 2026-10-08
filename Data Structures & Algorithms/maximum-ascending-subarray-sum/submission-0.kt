class Solution {
    fun maxAscendingSum(nums: IntArray): Int {
        var maxSum = nums[0]
        var curSum = nums[0]

        for (i in 1 until nums.size) {
            if (nums[i] > nums[i - 1]) {
                curSum += nums[i]
            } else {
                curSum = nums[i]
            }

            maxSum = maxOf(maxSum, curSum)
        }

        return maxSum
    }
}
