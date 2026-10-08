class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        for (i in nums.indices) {
            val indexToMark = abs(nums[i]) - 1
            if (nums[indexToMark] > 0) {
                nums[indexToMark] = - nums[indexToMark]
            }
        }

        val result = mutableListOf<Int>()
        for (i in nums.indices) {
            if (nums[i] > 0) {
                result.add(i + 1)
            }
        }

        return result
    }
}
