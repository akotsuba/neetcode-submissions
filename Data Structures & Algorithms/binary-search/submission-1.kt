class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size
        
        while (l < r) {
            val m = l + (r - l) / 2
            if (nums[m] >= target) {
                r = m
            } else {
                l = m + 1
            }
        }

        return if (l < nums.size && nums[l] == target) l else -1
    }
}
