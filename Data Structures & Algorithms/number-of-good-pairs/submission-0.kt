class Solution {
    fun numIdenticalPairs(nums: IntArray): Int {
        val counts = HashMap<Int, Int>()

        var result = 0

        for (num in nums) {
            counts[num] = counts.getOrDefault(num, 0) + 1
        }

        for (cnt in counts.values) {
            result += cnt * (cnt - 1) / 2
        }

        return result
    }
}