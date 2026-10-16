class Solution {

    fun decodeString(s: String): String {
        val countStack = ArrayDeque<Int>()
        val stringStack = ArrayDeque<StringBuilder>()

        var currentString = StringBuilder()
        var k = 0

        for (char in s) {
            if (char.isDigit()) {
                k = k * 10 + char.digitToInt()
            } else if (char == '[') {
                countStack.push(k)
                stringStack.push(currentString)
                k = 0
                currentString = StringBuilder()
            } else if (char == ']') {
                val repeatTimes = countStack.pop()
                val previousString = stringStack.pop()
                repeat(repeatTimes) {
                    previousString.append(currentString)
                }
                currentString = previousString
            } else {
                currentString.append(char)
            }
        }

        return currentString.toString()
    }  
}
