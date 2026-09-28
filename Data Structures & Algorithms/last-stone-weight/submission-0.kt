class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val heap = PriorityQueue<Int>(compareByDescending { it })

        stones.forEach { stone ->
            heap.add(stone)
        }

        while (heap.size > 1) {
            val first = heap.poll()
            val second = heap.poll()
            if (first > second) {
                heap.offer(first - second)
            }
        }

        return heap.peek() ?: 0
    }
}
