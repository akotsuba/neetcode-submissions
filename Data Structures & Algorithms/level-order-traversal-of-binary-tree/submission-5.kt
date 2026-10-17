/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null) return result

        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)

        while (queue.isNotEmpty()) {
            val elementsPerLevel = queue.size
            val elements = mutableListOf<Int>()

            repeat(elementsPerLevel) {
                val node = queue.removeFirst()
                elements.add(node.`val`)

                node?.left?.let { queue.addLast(it) }
                node?.right?.let { queue.addLast(it) }
            }

            result.add(elements)
        }

        return result
    }
}
