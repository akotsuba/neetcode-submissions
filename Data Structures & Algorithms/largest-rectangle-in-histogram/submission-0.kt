class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = ArrayDeque<Pair<Int, Int>>()

        var maxArea = 0

        heights.forEachIndexed { index, height ->
            if (stack.size == 0) {
                stack.push(index to height)
            } else {
                val top = stack.peek()
                if (height >= top.second) {
                    stack.push(index to height)
                } else {
                    var lastPoppedIndex = 0
                    while (stack.size > 0 &&  stack.peek().second > height) {
                        val popped = stack.pop()
                        lastPoppedIndex = popped.first
                        val b = (index - lastPoppedIndex) * popped.second
                        maxArea = max(maxArea, b)
                    }

                    stack.push(lastPoppedIndex to height)
                }
            }
        }

        stack.forEach {
            val area = (heights.size - it.first) * it.second
            maxArea = max(area, maxArea)
        }

        return maxArea
    }
}
