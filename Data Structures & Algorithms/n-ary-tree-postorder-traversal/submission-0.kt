/*
// Definition for a Node.
class Node(var `val`: Int) {
    var children: MutableList<Node> = mutableListOf()
}
*/

class Solution {
    fun postorder(root: Node?): List<Int> {
        val result = mutableListOf<Int>()

        fun dfs(node: Node?) {
            if (node == null) return

            node?.children?.forEach { child ->
                dfs(child)
            }

            node?.`val`?.let { result.add(it) }
        }

        dfs(root)

        return result
    }
}
