class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size

        while (l < r) {
            val m = l + (r - l) / 2
            val midValue = nums[m]

            when {
                target > midValue -> l = m + 1
                else -> r = m
            }
        }

        return l
    }
}
