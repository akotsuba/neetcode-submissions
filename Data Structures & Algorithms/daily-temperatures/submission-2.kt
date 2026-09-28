class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        if (temperatures.size == 0) return intArrayOf()

        val stack = ArrayDeque<Pair<Int, Int>>()

        val result = IntArray(temperatures.size) { 0 }

        stack.push(temperatures[0] to 0)

        for (i in 1..temperatures.size - 1) {
            val temp = temperatures[i]

            while (stack.size > 0 && temp > stack.peek().first) {
                val removed = stack.pop()
                val daysAmount = i - removed.second
                result[removed.second] = daysAmount
            } 

            stack.push(temp to i)
        }

        return result
    }
}
