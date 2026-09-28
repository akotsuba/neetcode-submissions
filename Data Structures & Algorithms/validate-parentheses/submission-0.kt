class Solution {
    val charactersMap = mapOf(
        '}' to '{',
        ')' to '(',
        ']' to '[',
    )

    fun isValid(s: String): Boolean {
        val stack = mutableListOf<Char>()

        s.forEach { char -> 
            val topChar = stack.lastOrNull()

            if (topChar != null && topChar == charactersMap[char]) {
                stack.removeLast()
            } else {
                stack.add(char)
            }
        }

        return stack.size == 0
    }
}
