class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)

        val stack = ArrayDeque<Int>() // indexes

        for (i in 0 until temperatures.size) {
            val t = temperatures[i]

            while (stack.isNotEmpty() && t > temperatures[stack.last()]) {
                val index = stack.removeLast()
                result[index] = i - index
            }

            stack.addLast(i)
        }

        return result
    }
}
