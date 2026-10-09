class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1

        while (l <= r) {
            val m = r + (l - r) / 2

            val midValue = nums[m]

            when {
                target == midValue -> return m
                target > midValue -> l = m + 1
                else -> r = m - 1
            }
        }

        return -1
    }
}
