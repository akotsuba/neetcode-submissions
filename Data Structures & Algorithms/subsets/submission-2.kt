class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val subset = mutableListOf<Int>()

        fun dfs(i: Int) {
            if (i >= nums.size) {
                result.add(subset.toList())
                return
            }

            subset.add(nums[i])
            dfs(i + 1)
            subset.removeLast()
            dfs(i + 1)
        }

        dfs(0)

        return result
    }
}
