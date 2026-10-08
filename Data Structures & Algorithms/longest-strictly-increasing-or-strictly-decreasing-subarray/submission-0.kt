class Solution {
    fun longestMonotonicSubarray(nums: IntArray): Int {
        var inc = 1
        var dec = 1
        var res = 1

        for (i in 1 until nums.size) {
            if (nums[i] == nums[i - 1]) {
                inc = 1
                dec = 1
            } else if (nums[i] > nums[i - 1]) {
                inc++
                dec = 1
            } else {
                inc = 1
                dec++
            }

            res = maxOf(res, inc, dec)
        }

        return res
    }
}
