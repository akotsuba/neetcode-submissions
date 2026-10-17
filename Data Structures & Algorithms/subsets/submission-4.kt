class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val subset = mutableListOf<Int>()

        fun backtrack(start: Int) {
            result.add(subset.toList())

            for (i in start until nums.size) {
                subset.add(nums[i])
                backtrack(i + 1)
                subset.removeLast()
            }
        }

        backtrack(0)

        return result
    }
}
