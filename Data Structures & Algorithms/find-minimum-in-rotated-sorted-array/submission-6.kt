class Solution {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1

        var res = nums[0]

        while (l <= r) {
            // if (nums[r] > nums[l]) return nums[l]

            val m = l + (r - l) / 2

            if (nums[m] <= nums[r]) {
                res = minOf(res, nums[m])
                r = m - 1
            } else {
                l = m + 1
            }
        }

        return res
    }
}
