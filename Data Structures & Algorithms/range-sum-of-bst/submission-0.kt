/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null) return 0
        
        var sum = if (root.`val` in low..high) root.`val` else 0

        if (root.`val` >= low) {
            sum += rangeSumBST(root.left, low, high) 
        }
        if (root.`val` <= high) {
            sum += rangeSumBST(root.right, low, high) 
        }

        return sum
    }
}
