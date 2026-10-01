class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val n = edges.size
        val parents = Array(n + 1) { it }

        fun find(u: Int): Int {
            if (u == parents[u]) return u

            parents[u] = find(parents[u])
            return parents[u]
        }

        fun union(u: Int, v: Int): Boolean {
            val parentU = find(u)
            val parentV = find(v)

            if (parentU == parentV) {
                return false
            } else {
                parents[parentV] = parentU
                return true
            }
        }

        for (edge in edges) {
            val (u, v) = edge
            if (!union(u, v)) {
                return edge
            }
        }

        return intArrayOf()
    }
}
