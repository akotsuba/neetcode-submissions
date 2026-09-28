/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var newHead = head 

        if (head?.next != null) {
            newHead = reverseList(head.next)
        }
        head?.next?.next = head
        head?.next = null

        return newHead
    }
}
