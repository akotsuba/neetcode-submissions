class Solution {
    fun maxArea(heights: IntArray): Int {
        var l = 0
        var r = heights.size - 1

        var result = 0

        while (l < r) {
            val volume = (r - l) * minOf(heights[r], heights[l])
            result = maxOf(result, volume)

            if (heights[l] < heights[r]) {
                l++
            } else {
                r--
            }
        }

        return result
    }
}
