class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val permutation = mutableListOf<Int>()
        val used = BooleanArray(nums.size)

        fun backtrack() {
            if (permutation.size == nums.size) {
                result.add(permutation.toList())
                return
            }

            for (i in 0 until nums.size) {
                if (used[i]) continue

                permutation.add(nums[i])
                used[i] = true

                backtrack()

                permutation.removeLast()
                used[i] = false
            }
            
        }

        backtrack()

        return result
    }
}
