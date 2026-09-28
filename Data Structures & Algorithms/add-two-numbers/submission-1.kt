/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var cur1 = l1
        var cur2 = l2
        var node = ListNode(-1)
        var head = node
        var cur: ListNode? = node

        var hasCarry = false
        while (cur1 != null || cur2 != null) {
            val sum = (cur1?.`val` ?: 0) + (cur2?.`val` ?: 0) + if (hasCarry) 1 else 0
            hasCarry = sum >= 10

            cur?.next = ListNode(sum % 10)
            cur = cur?.next
            cur1 = cur1?.next
            cur2 = cur2?.next
        } 

        if (hasCarry) {
            cur?.next = ListNode(1)
        }

        return node?.next
    }
}
