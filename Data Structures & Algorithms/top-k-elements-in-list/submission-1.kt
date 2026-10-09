class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val n = nums.size 
        val counts = HashMap<Int, Int>()
        for (num in nums) {
            counts[num] = counts.getOrDefault(num, 0) + 1
        }

        val arrayByFreq = Array<MutableList<Int>>(n + 1) { mutableListOf() }
        for ((num, freq) in counts) {
            arrayByFreq[freq].add(num)
        }

        // println(arrayByFreq.joinToString())

        var result = mutableListOf<Int>() 
        for (i in n downTo 1) {
            if (result.size == k) break 

            for (num in arrayByFreq[i]) {
                result.add(num)
            }
        }

        return result.toIntArray()
    }
}
