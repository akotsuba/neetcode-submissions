/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return listOf<List<Int>>()

        val query = ArrayDeque<TreeNode>()
        query.add(root)

        var result = mutableListOf<List<Int>>()

        while (query.size != 0) {
            val levelLength = query.size
            val elementsPerLevel = mutableListOf<Int>()

            for (i in 0 until levelLength) {
                val node = query.removeFirst()
                elementsPerLevel.add(node.`val`)
                
                node?.left?.let { query.add(it) }
                node?.right?.let { query.add(it) }
            }

            result.add(elementsPerLevel)
        }

        return result
    }
}
