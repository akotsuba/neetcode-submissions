/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        var slow: ListNode? = head
        var fast: ListNode? = head?.next

        while (fast != null && fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        // reverse 2nd half
        val second = slow?.next
        slow?.next = null // link between 2 halves

        var prev: ListNode? = null
        var curr = second
        while (curr != null) {
            val temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        }

        // merge 2 lists
        var first: ListNode? = head
        var secondNode: ListNode? = prev

        while (first != null && secondNode != null) {
            val temp1 = first?.next
            val temp2 = secondNode?.next

            first?.next = secondNode
            secondNode?.next = temp1

            first = temp1
            secondNode = temp2
        }
    }
}
