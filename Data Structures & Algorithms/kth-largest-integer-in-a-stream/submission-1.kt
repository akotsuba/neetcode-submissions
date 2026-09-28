class KthLargest(k: Int, nums: IntArray) {

    private val heap = PriorityQueue<Int>()
    private val maxHeapSize = k

    init {
        offerAndShrink(*nums)
    }

    fun add(`val`: Int): Int {
        offerAndShrink(`val`)

        return heap.peek()
    }

    private fun offerAndShrink(vararg nums: Int) {
        nums.forEach { num ->
            heap.offer(num)
        }
        while (heap.size > maxHeapSize) {
            heap.poll()
        }
    }
}
