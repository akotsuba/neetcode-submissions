class Solution {
    fun decodeString(s: String): String {
        val stack = mutableListOf<String>()

        for (c in s) {
            if (c != ']') {
                stack.add(c.toString())
            } else {
                var substr = ""
                while (stack.last() != "[") {
                    substr = stack.removeLast() + substr
                }
                stack.removeLast() // remove '['

                var k = ""
                while (stack.isNotEmpty() && stack.last()[0].isDigit()) {
                    k = stack.removeLast() + k
                }

                val count = k.toInt()
                stack.add(substr.repeat(count))
            }
        }

        return stack.joinToString("")
    }
        
}
