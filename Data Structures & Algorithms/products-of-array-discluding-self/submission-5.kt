class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }

        // products l -> r
        var prefix = 1
        for (i in 0 until nums.size) {
            result[i] = prefix
            prefix = prefix * nums[i]
        }

        var postfix = 1
        for (i in nums.size - 1 downTo 0) {
            result[i] = result[i] * postfix
            postfix = postfix * nums[i]
        }

        return result
    }
}
