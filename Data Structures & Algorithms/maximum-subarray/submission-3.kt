class Solution {
    // Kadane's algo

    fun maxSubArray(nums: IntArray): Int {
        var currentSum = 0
        var maxSum = nums[0]

        for (num in nums) {
            currentSum += num
            maxSum = max(maxSum, currentSum)

            if (currentSum < 0) {
                currentSum = 0
            } 
        }

        return maxSum
    }
}
