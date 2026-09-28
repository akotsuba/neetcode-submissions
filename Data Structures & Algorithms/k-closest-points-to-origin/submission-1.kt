class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val minHeap = PriorityQueue(compareBy<IntArray> { it[0] * it[0] + it[1] * it[1] })

        for (p in points) {
            minHeap.add(p)
        }

        val result = mutableListOf<IntArray>()
        repeat(k) {
            result.add(minHeap.poll())
        }

        return result.toTypedArray()
    }
}
