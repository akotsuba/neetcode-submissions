class Solution {
    fun moveZeroes(nums: IntArray) {
        var l = 0
        var r = 0

        while (r < nums.size) {
            if (nums[r] > 0) {
                nums[l++] = nums[r]
            }
            r++
        }
        while (l < nums.size) {
            nums[l++] = 0
        }
    }
}
