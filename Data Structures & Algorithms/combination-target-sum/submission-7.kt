class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()

        fun backtrack(start: Int, sum: Int) {
            // val sum = current.sum()
            if (sum > target) return
            if (sum == target) {
                result.add(current.toList())
                return
            }

            for (i in start until nums.size) {
                current.add(nums[i])
                backtrack(i, sum + nums[i])
                current.removeLast()
            }
        }

        backtrack(0, 0)

        return result
    }
}
