class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }

        var prefix = 1
        for (i in 0..nums.size - 2) {
            prefix *= nums[i]
            result[i + 1] = result[i + 1] * prefix
        }

        var postfix = 1
        for (i in nums.size - 1 downTo 1) {
            postfix *= nums[i]
            result[i - 1] = result[i - 1] * postfix
        }

        return result
    }
}
