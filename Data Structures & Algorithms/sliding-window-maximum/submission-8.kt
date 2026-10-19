class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        val indexQueue = ArrayDeque<Int>()
        val result = IntArray(n - k + 1)

        for (i in 0 until n) {
            // println("$indexQueue")

            val num = nums[i]
            val resultIndex = i - k + 1
            val indexToRemove = resultIndex - 1

            if (indexQueue.isNotEmpty() && indexQueue.first() == indexToRemove) {
                indexQueue.removeFirst()
            }
            
            while (indexQueue.isNotEmpty() && nums[indexQueue.last()] < num) {
                indexQueue.removeLast()
            }

            indexQueue.add(i)

            if (resultIndex >= 0) {
                result[resultIndex] = nums[indexQueue.first()]
            }
        }

        return result
    }
}
