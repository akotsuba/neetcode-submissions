class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        if (k == 0) return intArrayOf()

        val countMap = HashMap<Int, Int>()

        for (num in nums) {
            countMap[num] = countMap.getOrDefault(num, 0) + 1
        }

        val freq = List(nums.size + 1) { mutableListOf<Int>() }

        countMap.forEach { num, count ->
            freq[count].add(num)
        }

        val result = mutableListOf<Int>()
        for (i in freq.size - 1 downTo 1) {
            for (num in freq[i]) {
                result.add(num)
                if (result.size == k) {
                    return result.toIntArray()
                }
            }
        }

        return result.toIntArray()
    }
}
