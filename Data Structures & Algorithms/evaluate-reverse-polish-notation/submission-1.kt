class Solution {

    fun evalRPN(tokens: Array<String>): Int {
        val result = ArrayDeque<Int>()

        tokens.forEach { token ->
            when (token) {
                    "+" -> {
                        val res = result.pop() + result.pop()
                        result.push(res)
                    }
                    "-" -> {
                        val op1 = result.pop()
                        val op2 = result.pop()
                        val res = op2 - op1
                        result.push(res)
                    }
                    "*" -> {
                        val res = result.pop() * result.pop()
                        result.push(res)
                    }
                    "/" -> {
                        val op1 = result.pop()
                        val op2 = result.pop()
                        val res = op2 / op1

                        result.push(res)
                    }
                    else -> {
                        result.push(token.toInt())
                    }
                }
            
        }

        return result.pop()
    }
}
