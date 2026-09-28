/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return valid(
            root, 
            Int.MIN_VALUE, 
            Int.MAX_VALUE,
        )
    }

    fun valid(node: TreeNode?, left: Int, right: Int): Boolean {
        if (node == null) return true

        val leftValid = node.`val` > left
        val rightValid = node.`val` < right
        if ((leftValid && rightValid).not()) {
            return false
        }

        return valid(node.left, left, node.`val`) && valid(node.right, node.`val`, right)
    }
}
