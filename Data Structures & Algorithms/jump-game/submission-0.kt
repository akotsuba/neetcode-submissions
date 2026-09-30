class Solution {
    fun canJump(nums: IntArray): Boolean {
        var maxJump = 0
        val lastIndex = nums.size - 1

        for (i in 0 until nums.size) {
            if (i > maxJump) return false

            maxJump = max(maxJump, i + nums[i])

            if (maxJump >= lastIndex) return true
        }

        return true
    }
}
