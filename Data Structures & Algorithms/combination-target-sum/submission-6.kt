class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        var current = mutableListOf<Int>()

        fun backtrack(start: Int) {
            val sum = current.sum()
            if (sum > target) return
            if (sum == target) {
                result.add(current.toList())
                return
            }

            for (i in start until nums.size) {
                current.add(nums[i])
                backtrack(i)
                current.removeLast()
            }
        }

        backtrack(0)

        return result
    }
}
