class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numsSet = nums.toSet()

        var currentStreak = 1
        var result = 0

        for (num in nums) {
            if (num - 1 !in numsSet) {
                while (num + currentStreak in numsSet) {
                    currentStreak++
                }

                result = max(result, currentStreak)
                currentStreak = 1
            }
        }

        return result
    }
}
