/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.size == 0 || inorder.size == 0) return null

        val node = TreeNode(preorder[0])
        val mid = inorder.indexOf(preorder[0])

        node.left = buildTree(preorder.sliceArray(1 until mid + 1), inorder.sliceArray(0 until mid))
        node.right = buildTree(preorder.sliceArray(mid + 1 until preorder.size), inorder.sliceArray(mid + 1 until inorder.size))

        return node
    }
}
