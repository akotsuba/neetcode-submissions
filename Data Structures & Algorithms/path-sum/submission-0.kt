/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false

        val remainTarget = targetSum - root.`val`
        println("remain: $remainTarget")
        if (remainTarget == 0 && root.left == null && root.right == null) {
            return true
        }

        return hasPathSum(root.left, remainTarget) || hasPathSum(root.right, remainTarget)
    }
}
