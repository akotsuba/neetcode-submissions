class Solution {
    fun calPoints(operations: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        for (op in operations) {
            when (op) {
                "+" -> {
                    if (stack.size >= 2) {
                        val top = stack.removeLast()
                        val sum = top + stack.last()
                        stack.addLast(top)
                        stack.addLast(sum)
                    }
                }
                "D" -> {
                    if (stack.isNotEmpty()) {
                        stack.addLast(stack.last() * 2)
                    }
                }
                "C" -> {
                    if (stack.isNotEmpty()) {
                        stack.removeLast()
                    }
                }
                else -> stack.addLast(op.toInt())
            }

            println("$stack")
        }

        return stack.sum()
    }
}
