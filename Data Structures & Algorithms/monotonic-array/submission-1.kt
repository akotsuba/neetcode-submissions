class Solution {
    fun isMonotonic(nums: IntArray): Boolean {
        var increasing: Boolean? = null

        for (i in 1 until nums.size) {
            if (increasing == true && nums[i] < nums[i - 1]) {
                return false
            }
            if (increasing == false && nums[i] > nums[i - 1]) {
                return false
            }
            if (increasing == null && nums[i] != nums[i - 1]) {
                increasing = nums[i] > nums[i - 1]
            }
        }

        return true
    }
}