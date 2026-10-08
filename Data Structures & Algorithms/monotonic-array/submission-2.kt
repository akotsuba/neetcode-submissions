class Solution {
    fun isMonotonic(nums: IntArray): Boolean {
        var increase = true
        var decrease = true

        for (i in 0 until nums.size - 1) {
            if (nums[i] > nums[i + 1]) increase = false
            if (nums[i] < nums[i + 1]) decrease = false

            if (!increase && !decrease) return false
        }

        return true
    }
}