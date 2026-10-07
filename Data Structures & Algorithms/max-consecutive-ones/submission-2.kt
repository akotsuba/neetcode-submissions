class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max = 0
        var curMax = 0

        for (num in nums) {
            if (num == 1) {
                curMax++
                max = maxOf(max, curMax)
            } else {
                curMax = 0
            }
        }

        return max
    }
}
