/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        return dfs(root).first
    }

    fun dfs(root: TreeNode?): Pair<Boolean, Int> {
        if (root == null) return true to 0

        val left = dfs(root?.left)
        val right = dfs(root?.right)
        val balanced = left.first && right.first && 
            Math.abs(left.second - right.second) <= 1

        return Pair(balanced, 1 + max(left.second, right.second))
    }
}
