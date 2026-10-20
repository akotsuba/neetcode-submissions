class Solution {
    fun jump(nums: IntArray): Int {
        if (nums.size == 1) return 0
        
        var jumps = 0
        var curFarthest = 0
        var farthest = 0
        val goal = nums.size - 1

        for (i in nums.indices) {
            farthest = maxOf(farthest, i + nums[i])

            if (i == curFarthest) {
                jumps++
                curFarthest = farthest

                if (curFarthest >= goal) break
            }
        }

        return jumps
    }
}
