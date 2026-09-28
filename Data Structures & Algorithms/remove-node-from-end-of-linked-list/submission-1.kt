/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head?.next == null) return null

        val dummy = ListNode(0)
        dummy.next = head

        var l: ListNode? = dummy
        var r = head
        for (i in 0..n - 1) {
            r = r?.next
        }

        println("${r?.`val`}") 

        while (r != null) {
            l = l?.next
            r = r?.next
        }

        println("${l?.`val`}") 

        l?.next = l?.next?.next

        return dummy.next
    }
}
