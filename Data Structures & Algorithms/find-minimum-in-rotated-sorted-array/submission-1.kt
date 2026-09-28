class Solution {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1

        while (l < r) {
            if (nums[r] > nums[l]) return nums[l]

            val m = l + (r - l) / 2

            if (nums[m] >= nums[l]) {
                l = m + 1
            } else {
                r = m 
            }
        }

        return nums[l]
    }
}
