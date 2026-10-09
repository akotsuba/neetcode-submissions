class MyQueue() {

    val inStack = ArrayDeque<Int>()
    val outStack = ArrayDeque<Int>()

    fun push(x: Int) {
        inStack.push(x)
    }

    fun pop(): Int {
        formOutStack()
        return outStack.pop()
    }

    fun peek(): Int {
        formOutStack()
        return outStack.peek()
    }

    fun empty(): Boolean {
        return inStack.isEmpty() && outStack.isEmpty()
    }

    private fun formOutStack() {
        if (outStack.isEmpty()) {
            while (inStack.isNotEmpty()) {
                outStack.push(inStack.pop())
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * val obj = MyQueue()
 * obj.push(x)
 * val param_2 = obj.pop()
 * val param_3 = obj.peek()
 * val param_4 = obj.empty()
 */
