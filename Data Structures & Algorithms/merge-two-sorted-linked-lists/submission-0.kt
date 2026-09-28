/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var cur1 = list1
        var cur2 = list2

        
        var head: ListNode? = null
        var node: ListNode? = null

        while (cur1 != null && cur2 != null) {
            if (cur1.`val` < cur2.`val`) {
                if (head == null) {
                    head = cur1
                    node = head
                } else {
                    head?.next = cur1
                    head = head?.next
                }
                cur1 = cur1.next
            } else {
                if (head == null) {
                    head = cur2
                    node = head
                } else {
                    head?.next = cur2
                    head = head?.next
                }
                cur2 = cur2.next
            }

            

            println("${head?.`val`}")
        }

        if (head == null) {
            head = cur1 ?: cur2
            node = head
        } else {
            head?.next = cur1 ?: cur2
        }

        return node
    }
}
