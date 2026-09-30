class Solution {
    fun checkValidString(s: String): Boolean {
        val openStack = ArrayDeque<Int>()
        val starStack = ArrayDeque<Int>()

        for (i in s.indices) {
            when (s[i]) {
                '(' -> openStack.push(i)
                ')' -> {
                    if (openStack.isNotEmpty()) {
                        openStack.pop()
                    } else if (starStack.isNotEmpty()) {
                        starStack.pop()
                    } else {
                        return false
                    }
                }
                '*' -> starStack.push(i)
            }
        }

        while (openStack.isNotEmpty() && starStack.isNotEmpty()) {
            if (starStack.pop() < openStack.pop()) {
                return false
            }
        }

        return openStack.isEmpty()
    }
}
