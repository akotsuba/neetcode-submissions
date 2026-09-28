class Solution {
    fun trap(height: IntArray): Int {
        var result = 0

        var l = 0
        var r = height.size - 1

        var maxL = height[l]
        var maxR = height[r]

        while (l < r) {
            if (maxL < maxR) {
                val area = max(min(maxL, maxR) - height[l], 0)

                result += area
                l++

                maxL = max(maxL, height[l])
            } else {
                val area = max(min(maxL, maxR) - height[r], 0)

                result += area
                r--

                maxR = max(maxR, height[r])
            }
        }

        return result
    }
}
