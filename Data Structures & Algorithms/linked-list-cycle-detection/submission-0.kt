/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var sp = head
        var fp = head?.next

        while (fp != null) {
            if (sp == fp) return true
            sp = sp?.next
            fp = fp?.next?.next
        }

        return false
    }
}
