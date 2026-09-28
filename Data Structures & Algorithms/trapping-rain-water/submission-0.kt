class Solution {
    fun trap(height: IntArray): Int {
        var result = 0

        var l = 0
        var r = height.size - 1

        var maxL = 0
        var maxR = 0

        while (l < r) {
            maxL = max(maxL, height[l])
            maxR = max(maxR, height[r])

            if (maxL < maxR) {
                val area = max(min(maxL, maxR) - height[l], 0)

                result += area
                l++
            } else {
                val area = max(min(maxL, maxR) - height[r], 0)

                result += area
                r--
            }
        }

        return result
    }
}
