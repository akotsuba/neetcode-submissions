/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var result = 0
        
        fun dfs(root: TreeNode?): Int {
            if (root == null) return 0

            val leftHeight = dfs(root?.left)
            val rightHeight = dfs(root?.right)

            val diameter = leftHeight + rightHeight
            result = maxOf(result, diameter)

            return 1 + maxOf(leftHeight, rightHeight)
        }

        dfs(root)

        return result
    }
}
