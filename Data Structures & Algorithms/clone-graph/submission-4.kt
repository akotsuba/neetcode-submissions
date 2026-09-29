/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {    
    private val visited = HashMap<Node, Node>()

    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
        if (visited.contains(node)) return visited[node]

        val cloned = Node(node.`val`)
        visited[node] = cloned

        for (neighbor in node.neighbors) {
            cloned?.neighbors?.add(cloneGraph(neighbor))
        }

        return cloned
    }
}
