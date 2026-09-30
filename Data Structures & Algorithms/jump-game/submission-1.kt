class Solution {

    /* O(n)

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
    */

    fun canJump(nums: IntArray): Boolean {
        var goal = nums.size - 1

        for (i in nums.size - 2 downTo 0) {
            if (nums[i] + i >= goal) {
                goal = i
            }
        }

        return goal == 0
    }

}
