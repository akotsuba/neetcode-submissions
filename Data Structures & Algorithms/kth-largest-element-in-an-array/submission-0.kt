class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val maxHeap = PriorityQueue<Int>({ it1, it2 -> it2 - it1 })

        for (num in nums) {
            maxHeap.add(num)
        }

        repeat(k - 1) {
            maxHeap.poll()
        }

        return maxHeap.poll()
    }
}
