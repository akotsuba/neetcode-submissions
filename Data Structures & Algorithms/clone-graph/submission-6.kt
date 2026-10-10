/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    val nodesMap = HashMap<Node, Node>()

    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null

        if (node in nodesMap) return nodesMap[node]!!

        val copy = Node(node.`val`)
        nodesMap[node] = copy

        for (neighbor in node.neighbors) {
            neighbor?.let { copy.neighbors.add(cloneGraph(it)) }
        }

        return copy
    }
}
