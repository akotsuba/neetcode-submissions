class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val graph = mutableMapOf<Int, MutableList<IntArray>>() // u : [v, w]
        for ((u, v, w) in times) {
            graph.computeIfAbsent(u) {
                mutableListOf<IntArray>()
            }.add(intArrayOf(v, w))
        }

        val minHeap = PriorityQueue<IntArray>(compareBy { it[0]} ) // time, to node
        minHeap.offer(intArrayOf(0, k))

        val visited = HashSet<Int>()

        var resultTime = 0

        while (minHeap.isNotEmpty()) {
            val (time, node) = minHeap.poll()

            if (node in visited) continue 
            visited.add(node)

            resultTime = time // current we have

            graph[node]?.forEach { (nextNode, weight) ->
                if (nextNode !in visited) {
                    // add
                    minHeap.offer(intArrayOf(time + weight, nextNode))
                }
            }

        }

        return if (visited.size == n) resultTime else -1
    }
}
