/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return listOf<Int>()

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        val result = mutableListOf<Int>()

        while (queue.isNotEmpty()) {
            val levelSize = queue.size

            for (i in 0 until levelSize) {
                val node = queue.removeFirst()
                node?.left?.let { queue.add(it) }
                node?.right?.let { queue.add(it) }

                if (i == levelSize - 1) {
                    result.add(node.`val`)
                }
            }
        }

        return result
    }
}
