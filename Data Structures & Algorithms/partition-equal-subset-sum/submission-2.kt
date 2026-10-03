class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val totalSum = nums.sum()
        if (totalSum % 2 != 0) return false
        val targetSum = totalSum / 2

        val memo = HashMap<Pair<Int, Int>, Boolean>()
        
        fun dfs(i: Int, currentSum: Int): Boolean {
            if (currentSum == targetSum) return true
            if (memo.contains(i to currentSum)) return memo[i to currentSum]!!
            if (currentSum > targetSum) return false
            if (i == nums.size) return false

            val result = dfs(i + 1, currentSum) || dfs(i + 1, currentSum + nums[i])
            memo[i to currentSum] = result
            return result
        }

        return dfs(0, 0)
    }
}
