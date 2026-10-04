/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()

        fun dfs(node: TreeNode?) {
            if (node?.left == null && node?.right == null) {
                node?.`val`?.let { result.add(it) }
                return 
            }

            dfs(node?.left)
            node?.`val`?.let { result.add(it) }
            dfs(node?.right)
        }

        dfs(root)

        return result
    }
}
