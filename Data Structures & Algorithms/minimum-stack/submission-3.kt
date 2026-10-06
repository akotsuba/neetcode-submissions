class MinStack() {

    private val stack = mutableListOf<Int>()
    private val currentMin = mutableListOf<Int>()

    fun push(`val`: Int) {
        stack.add(`val`)
        currentMin.add(min(`val`, currentMin.lastOrNull() ?: Int.MAX_VALUE))
    }

    fun pop() {
        stack.removeLast()
        currentMin.removeLast()
    }

    fun top(): Int {
        return stack.lastOrNull() ?: 0
    }

    fun getMin(): Int {
        return currentMin.lastOrNull() ?: 0
    }
}
