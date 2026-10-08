class Solution {
    fun check(nums: IntArray): Boolean {
        val n = nums.size

        var maxInc = 1
        for (i in 1 until 2 * n) {
            val curI = i % n
            val prevI = (i - 1) % n

            if (nums[curI] >= nums[prevI]) {
                maxInc++
            } else {
                maxInc = 1
            }

            println("$maxInc")

            if (maxInc == n) return true
        }

        return false
    }
}