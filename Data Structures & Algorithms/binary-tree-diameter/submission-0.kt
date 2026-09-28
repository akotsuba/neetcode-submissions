/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var result = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)

        return result
    }

    fun dfs(root: TreeNode?): Int {
        if (root == null) return 0

        val leftHeight = dfs(root?.left)
        val rightHeight = dfs(root?.right)

        result = max(result, leftHeight + rightHeight)

        return 1 + max(leftHeight, rightHeight)
    }
}

