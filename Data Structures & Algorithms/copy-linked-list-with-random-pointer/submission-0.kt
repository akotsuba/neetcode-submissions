/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        val map = HashMap<Node?, Node?>()

        var cur = head

        while (cur != null) {
           map[cur] = Node(cur.`val`)
           cur = cur?.next
        }

        cur = head
        while (cur != null) {
           map[cur]?.next = map[cur?.next]
           map[cur]?.random = map[cur?.random]
           cur = cur?.next
        }

        return map[head]
    }
}
