class Solution {
    fun missingNumber(nums: IntArray): Int {
        var res = nums.size
        for (i in nums.indices) {
            res += i - nums[i]
        }

        return res
    }
}
