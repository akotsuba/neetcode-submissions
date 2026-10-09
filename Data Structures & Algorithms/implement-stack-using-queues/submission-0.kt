class MyStack() {

    private val queue = ArrayDeque<Int>()

    fun push(x: Int) {
        queue.addLast(x)

        val size = queue.size
        repeat(size - 1) {
            queue.addLast(pop())
        }
    }

    fun pop(): Int {
        return queue.removeFirst()
    }

    fun top(): Int {
        return queue.first()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * val obj = MyStack()
 * obj.push(x)
 * val param_2 = obj.pop()
 * val param_3 = obj.top()
 * val param_4 = obj.empty()
 */
