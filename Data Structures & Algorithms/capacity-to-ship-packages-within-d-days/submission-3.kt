class Solution {
    fun shipWithinDays(weights: IntArray, days: Int): Int {
        var l = weights.max()
        var r = weights.sum()

        var res = r

        while (l < r) {
            val cap = l + (r - l) / 2

            var daysReq = 1
            var curCap = 0
            for (w in weights) {
                if (curCap + w > cap) {
                    daysReq++
                    curCap = 0
                }
                curCap += w
            }

            when {
                daysReq <= days -> {
                    // res = cap
                    r = cap // - 1
                }
                else -> l = cap + 1
            }
        }

        return l
    }
}
