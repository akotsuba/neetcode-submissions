class Solution {
    fun jump(nums: IntArray): Int {
        if (nums.size <= 1) return 0

        var jumps = 0
        var curEnd = 0
        var farthest = 0

        for (i in 0 until nums.size) {
            farthest = max(farthest, i + nums[i])

            if (i == curEnd) {
                jumps++
                curEnd = farthest

                if (farthest >= nums.size - 1) {
                    break
                }
            }
        }

        return jumps
    }
}
