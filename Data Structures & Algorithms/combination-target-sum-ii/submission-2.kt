class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        candidates.sort()

        var cur = mutableListOf<Int>()
        fun dfs(i: Int, sum: Int) {
            if (sum == target) {
                result.add(cur.toList())
                return
            }

            for (j in i until candidates.size) {
                if (j > i && candidates[j] == candidates[j - 1]) {
                    continue
                }

                if (sum + candidates[j] > target) break

                cur.add(candidates[j])
                dfs(j + 1, sum + candidates[j])
                cur.removeLast()
            }
        }

        dfs(0, 0)
        
        return result
    }
}
