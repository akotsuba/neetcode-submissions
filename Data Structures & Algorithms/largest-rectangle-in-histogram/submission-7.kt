class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = ArrayDeque<Int>() // column indexes

        var maxArea = 0
        for (i in 0..heights.size) {
            val curHeight = if (i == heights.size) 0 else heights[i]

            while (stack.isNotEmpty() && curHeight < heights[stack.last()]) {
                val lastIndex = stack.removeLast()

                val leftBoundary = if (stack.isEmpty()) -1 else stack.last()
                val width = i - leftBoundary - 1
                val area = heights[lastIndex] * width
                maxArea = maxOf(maxArea, area)
            }

            if (i < heights.size) stack.add(i)
        }

        return maxArea
    }
}
