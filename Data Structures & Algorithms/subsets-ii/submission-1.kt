class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val subset = mutableListOf<Int>()

        nums.sort()

        fun backtrack(start: Int) {
            result.add(subset.toList())

            for (i in start until nums.size) {
                if (i > start && nums[i] == nums[i - 1]) continue

                subset.add(nums[i])
                backtrack(i + 1)
                subset.removeLast()
            }
        }

        backtrack(0)

        return result
    }
}
