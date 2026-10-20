class Solution {
    fun canJump(nums: IntArray): Boolean {
        // either start - end or end - start

        var maxJump = 0
        val goal = nums.size - 1

        for (i in nums.indices) {
            if (i > maxJump) return false

            maxJump = maxOf(maxJump, i + nums[i])

            if (maxJump >= goal) return true
        }

        return false
    }
}
