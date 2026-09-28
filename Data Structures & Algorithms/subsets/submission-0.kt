class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        
        var currentSubset = mutableListOf<Int>()
        
        fun dfs(i: Int) {
            if (i >= nums.size) {
                result.add(currentSubset.toList())
                return
            }

            currentSubset.add(nums[i])
            dfs(i + 1)
            currentSubset.removeLast()
            dfs(i + 1)
        }

        dfs(0)

        return result
    }
}
