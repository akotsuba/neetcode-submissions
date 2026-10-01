class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val n = points.size

        // count all distances: u <--> v | u, v, dist
        val edges = mutableListOf<IntArray>()

        for (u in 0 until n) {
            for (v in u + 1 until n) {
                val dist = abs(points[u][0] - points[v][0]) + abs(points[u][1] - points[v][1])
                edges.add(intArrayOf(u, v, dist))
            }
        }

        edges.sortBy { it[2] }

        val parents = Array(n) { it }

        fun find(u: Int): Int {
            if (u == parents[u]) return u

            parents[u] = find(parents[u])
            return parents[u]
        }

        fun merge(u: Int, v: Int): Boolean {
            val parentU = find(u)
            val parentV = find(v)

            if (parentU == parentV) {
                return false
            } else {
                parents[parentV] = parentU
                return true
            }
        }

        // Count sum here

        var minCost = 0
        var edgesCount = 0

        for (edge in edges) {
            val (u, v, cost) = edge

            if (merge(u, v)) {
                minCost += cost
                edgesCount++

                if (edgesCount == n - 1) break
            }            
        }

        return minCost
    }
}
