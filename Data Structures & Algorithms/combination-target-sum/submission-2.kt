class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        if (nums.size == 0) return result
        nums.sort()

        var cur = mutableListOf<Int>()

        fun dfs(i: Int, sum: Int) {
            if (sum == target) {
                result.add(cur.toList())
                return
            }
            
            for (j in i until nums.size) {
                if (sum + nums[j] > target) {
                    return
                }

                cur.add(nums[j])
                dfs(j, sum + nums[j])
                cur.removeLast()
            }
        }

        dfs(0, 0)

        return result
    }
}
