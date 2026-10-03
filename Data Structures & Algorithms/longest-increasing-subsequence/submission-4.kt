class Solution {
    /* top-bottom + memo O(2^n)
    
    fun lengthOfLIS(nums: IntArray): Int {

        val memo = HashMap<Pair<Int, Int>, Int>()

        fun dfs(cur: Int, prev: Int): Int {
            if (cur == nums.size) return 0
            if (memo.contains(cur to prev)) return memo[cur to prev]!!
            
            val notTaken = dfs(cur + 1, prev)

            val isBigger = prev == -1 || nums[cur] > nums[prev]
            val taken = if (isBigger) 1 + dfs(cur + 1, cur) else 0

            val res = maxOf(taken, notTaken)
            memo[cur to prev] = res

            return res
        }

        return dfs(0, -1)
    }
    */

    // Bottom-up O(n^2) / O(n)

    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        val n = nums.size
        val dp = Array(n) { 1 } // dp[i] = LIS up until nums[i]

        var result = 1

        for (i in 1 until n) {
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    dp[i] = max(dp[i], dp[j] + 1)
                }
            }

            result = max(result, dp[i])
        }

        return result
    }
}
