class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {

        val graph = HashMap<String, PriorityQueue<String>>()

        for (ticket in tickets) {
            val (from, to) = ticket
            graph.computeIfAbsent(from) { PriorityQueue<String>() }.add(to)
        }

        val result = mutableListOf<String>()

        fun dfs(from: String) {
            val destinations = graph[from]
            while (destinations != null && destinations.isNotEmpty()) {
                val dest = destinations.poll()
                dfs(dest)
            }

            result.add(from)
        }

        dfs("JFK")

        return result.reversed()
    }
}
