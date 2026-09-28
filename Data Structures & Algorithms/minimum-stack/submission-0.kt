class MinStack() {

    private val stack = mutableListOf<Int>()
    private val currentMin = mutableListOf<Int>()

    fun push(`val`: Int) {
        stack.add(`val`)

        if (currentMin.size == 0) {
            currentMin.add(`val`)
        } else {
            currentMin.add(min(`val`, currentMin.last()))
        }
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
