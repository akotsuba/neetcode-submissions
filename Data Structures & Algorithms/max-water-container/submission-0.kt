class Solution {
    fun maxArea(heights: IntArray): Int {
        var l = 0
        var r = heights.size - 1
        var maxArea = 0

        while (l < r) {
            val area = (r - l) * min(heights[l], heights[r])
            maxArea = max(maxArea, area)

            if (heights[l] > heights[r]) {
                r--
            } else {
                l++
            }
        }
        
        return maxArea
    }
}
