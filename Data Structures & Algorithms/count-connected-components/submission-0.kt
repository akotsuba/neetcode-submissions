class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val parent = IntArray(n) { it } // n trees for n nodes

        var components = n

        fun find(u: Int): Int {
            if (parent[u] == u) return u

            parent[u] = find(parent[u])
            return parent[u]
        }

        fun union(u: Int, v: Int) {
            val parentU = find(u)
            val parentV = find(v)

            if (parentU != parentV) {
                parent[parentV] = parentU
                components--
            }
        }

        for (edge in edges) {
            val (u, v) = edge
            union(u, v)
        }

        return components
    }
}
