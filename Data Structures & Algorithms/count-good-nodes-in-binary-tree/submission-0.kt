/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        return dfs(root, root?.`val` ?: 0)
    }

    fun dfs(root: TreeNode?, maxValue: Int): Int {
        if (root == null) return 0
        
        var goodNodes = 0

        if (root.`val` >= maxValue) {
            goodNodes++
        }

        val newMaxValue = max(maxValue, root.`val`)
        goodNodes += dfs(root?.left, newMaxValue)
        goodNodes += dfs(root?.right, newMaxValue)

        return goodNodes
    }
}
