class Solution {

    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0) return false

        val expectedChars = ArrayDeque<Char>()

        for (c in s) {
            when (c) {
                '{' -> expectedChars.addLast('}')
                '[' -> expectedChars.addLast(']')
                '(' -> expectedChars.addLast(')')
                else -> {
                    if (expectedChars.isEmpty() || expectedChars.removeLast() != c) {
                        return false
                    }
                }
            }
        }

        return expectedChars.isEmpty()
    }
}
