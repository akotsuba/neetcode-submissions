class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        var result = mutableListOf<List<Int>>()

        nums.sort()

        fun backtrack(i: Int, subset: MutableList<Int>) {
            if (i == nums.size) {
                println("$subset")
                result.add(subset.toList())
                return
            }

            subset.add(nums[i])
            println(">> i = $i subset = $subset")
            backtrack(i + 1, subset)
            subset.removeLast()
            println("<< i = $i subset = $subset")

            var j = i
            while (j < nums.size - 1 && nums[j] == nums[j + 1]) {
                println("skip $j")
                j++
            }

            backtrack(j + 1, subset)
        }

        backtrack(0, mutableListOf())

        return result
    }
}
