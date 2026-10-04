/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()

        fun dfs(node: TreeNode?) {
            if (node == null) return

            dfs(node?.left)
            dfs(node?.right)

            node?.`val`?.let { result.add(it) }
            
        }

        dfs(root)

        return result
    }
}
