class Solution {
    fun calculate(s: String): Int {
        val str = s.replace(" ", "")
        val stack = mutableListOf<Int>()
        var num = 0
        var op = '+'

        for (i in str.indices) {
            val c = str[i]

            if (c.isDigit()) {
                num = num * 10 + (c - '0')
            }

            if (!c.isDigit() || i == str.length - 1) {
                when (op) {
                    '+' -> stack.add(num)
                    '-' -> stack.add(-num)
                    '*' -> stack.add(stack.removeLast() * num)
                    '/' -> stack.add(stack.removeLast() / num)
                }
                op = c
                num = 0
            }
        }

        return stack.sum()
    }
}
