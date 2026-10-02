class Solution {
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
}
