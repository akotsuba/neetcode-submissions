/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var cur: ListNode? = dummy

        var cur1 = l1
        var cur2 = l2
        var carry = 0

        while (cur1 != null || cur2 != null || carry != 0) {
            val digit1 = cur1?.`val` ?: 0
            val digit2 = cur2?.`val` ?: 0
            val sum = digit1 + digit2 + carry
            val newDigit = sum % 10
            carry = sum / 10

            cur?.next = ListNode(newDigit)
            cur = cur?.next
            cur1 = cur1?.next
            cur2 = cur2?.next
        }

        return dummy?.next
    }
}
