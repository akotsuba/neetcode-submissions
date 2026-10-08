class Solution {
    fun pivotIndex(nums: IntArray): Int {
        var totalSum = nums.sum()

        var curSum = 0
        for (i in 0 until nums.size) {
            val remainSum = totalSum - curSum
            curSum += nums[i]

            if (remainSum == curSum) {
                return i
            }
        }

        return -1
    }
}
