class Solution {

    // 1. NO cycles
    // 2. all nodes are connected
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if (edges.size != n - 1) return false // edges = vertices - 1

        // detect no cycles! BFS

        val graph = HashMap<Int, MutableList<Int>>() 
        for (edge in edges) {
            val (u, v) = edge
            graph.computeIfAbsent(u) { mutableListOf<Int>() }.add(v)
            graph.computeIfAbsent(v) { mutableListOf<Int>() }.add(u)
        }

        val queue = ArrayDeque<Int>()
        val visited = HashSet<Int>()

        queue.add(0)
        visited.add(0)

        while (queue.isNotEmpty()) {
            val u = queue.poll()

            graph[u]?.forEach { v ->
                if (v !in visited) {
                    queue.add(v)
                    visited.add(v)    
                }
            }
            
        }

        return visited.size == n
    }
}
