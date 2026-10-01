class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        // create a structure for directed edges
        val graph = HashMap<Int, MutableList<Pair<Int, Int>>>()

        times.forEach { time ->
            val (u, v, time) = time
            graph.computeIfAbsent(u) { mutableListOf() }.add(v to time)
        }

        val dist = Array(n + 1) { Int.MAX_VALUE }
        dist[k] = 0    

        // use MinHeap by distance, loop throw all the nodes

        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        minHeap.add(k to 0)

        while (minHeap.isNotEmpty()) {
            val (u, curDist) = minHeap.poll()

            if (curDist > dist[u]) continue // !!! clarify

            graph[u]?.forEach { (v, weight) ->
                
                val newDist = curDist + weight
                if (newDist < dist[v]) {
                    dist[v] = newDist
                    minHeap.add(v to newDist)
                }
            }
        }

        // find required time (max time if not INFINITE)

        

        var result = 0
        for (i in 1 until dist.size) {
            val dis = dist[i]
            if (dis == Int.MAX_VALUE) return -1
            result = max(result, dis)
        }

        return result
    }
}
