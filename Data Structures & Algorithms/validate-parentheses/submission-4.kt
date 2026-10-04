class Solution {

    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0) return false 

        val stack = mutableListOf<Char>()

        for (c in s) {
            when (c) {
                '(' -> stack.addLast(')')
                '{' -> stack.addLast('}')
                '[' -> stack.addLast(']')
                else -> {
                    if (stack.isEmpty() || stack.removeLast() != c) {
                        return false
                    } 
                }
            }
        }

        return stack.isEmpty()
    }
}
