/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    // 1 -> 2 -> 3
    fun reverseList(head: ListNode?): ListNode? {
        var cur = head // 1
        var prev: ListNode? = null

        while (cur != null) {
            val next = cur.next // 2
            cur.next = prev
            prev = cur
            cur = next
        }

        return prev
    }
}
