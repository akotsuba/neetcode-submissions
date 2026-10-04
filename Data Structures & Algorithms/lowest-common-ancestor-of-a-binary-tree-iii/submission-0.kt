/*
// Definition for a Node.
class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var parent: Node? = null
}
*/

class Solution {
    fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
        var p1 = p
        var p2 = q

        while (p1 != p2) {
            p1 = if (p1 == null) q else p1.parent
            p2 = if (p2 == null) p else p2.parent
        }

        return p1
    }
}
