/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        if (root == null) return -1

        val stack = ArrayDeque<TreeNode>()
        var cur = root
        
        var processed = 0

        while (stack.size > 0 || cur != null) {
            while (cur != null) {
                stack.add(cur)
                cur = cur?.left
            }

            cur = stack.removeLast()

            processed++
            if (processed == k) return cur?.`val` ?: -1

            cur = cur?.right
        }

        return -1
    }
}
