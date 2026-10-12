class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {

        var l = 1 
        var r = piles.max()
        var res = r

        while (l <= r) {
            val m = l + (r - l) / 2
            var hoursReq = 0
            for (pile in piles) {
                hoursReq += (pile + m - 1) / m
            }

            when {
                hoursReq <= h -> {
                    res = m
                    r = m - 1
                }
                else -> l = m + 1
            }
        }

        return res
    }
}
