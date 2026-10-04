/*
// Definition for a Node.
class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}
*/

class Solution {
    fun connect(root: Node?): Node? {
        if (root == null) return null

        val queue = ArrayDeque<Node>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val currentSize = queue.size

            for (i in 0 until currentSize) {
                val node = queue.removeFirst()

                node.next = if (i == currentSize - 1) null else queue.peek()

                if (node.left != null) queue.add(node.left)
                if (node.right != null) queue.add(node.right)

                println("${node.`val`} -> ${queue.peek()?.`val`}")
            }

            println("----")
        }

        return root
    }
}
