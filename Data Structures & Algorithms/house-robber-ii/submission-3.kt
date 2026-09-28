class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 0) return 0
        if (nums.size == 1) return nums[0]

        fun getRobMax(start: Int, end: Int): Int {
            var p2 = 0
            var p1 = 0

            for (i in start..end) {
                val cur = max(nums[i] + p2, p1)
                p2 = p1
                p1 = cur
            }

            return p1
        }

        val op1 = getRobMax(0, nums.size - 2)
        val op2 = getRobMax(1, nums.size - 1)

        return max(op1, op2)
    }
}
