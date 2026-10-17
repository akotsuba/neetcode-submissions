/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (subRoot == null) return true
        if (root == null) return false

        fun isSameTree(root: TreeNode?, subRoot: TreeNode?): Boolean {
            if (root == null && subRoot == null) {
                return true
            }

            return root?.`val` == subRoot?.`val` &&
                isSameTree(root?.left, subRoot?.left) &&
                isSameTree(root?.right, subRoot?.right) 
        }

        return isSameTree(root, subRoot) || 
            isSubtree(root?.left, subRoot) || 
            isSubtree(root?.right, subRoot)
    }
}
