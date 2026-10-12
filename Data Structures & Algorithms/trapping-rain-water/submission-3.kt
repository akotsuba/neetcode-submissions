class Solution {
    fun trap(height: IntArray): Int {
        var l = 0
        var r = height.size - 1

        var lMax = 0
        var rMax = 0

        var water = 0

        while (l < r) {
            if (height[l] < height[r]) {
                // count left side
                if (lMax > height[l]) {
                    water += lMax - height[l]
                } else {
                    lMax = height[l]
                }

                l++
            } else {
                if (rMax > height[r]) {
                    water += rMax - height[r]
                } else {
                    rMax = height[r]
                }

                r--
            }
        }

        return water
    }
}
