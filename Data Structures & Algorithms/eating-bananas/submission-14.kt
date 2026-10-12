class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var l = 1
        var r = piles.max()

        var res = -1

        while (l <= r) {
            val bph = l + (r - l) / 2
            var hoursRequired = 0

            for (pile in piles) {
                hoursRequired += (pile + bph - 1) / bph
            }

            if (hoursRequired <= h) {
                res = bph
                r = bph - 1
            } else {
                l = bph + 1
            }
        }

        return res
    }
}
