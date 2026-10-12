class Solution {
    fun mySqrt(x: Int): Int {
        if (x == 0) return 0

        var l = 1
        var r = x

        var res = -1

        while (l <= r) {
            val m = l + (r - l) / 2
            val sq = m * m.toLong()

            if (sq <= x) {
                res = m
                l = m + 1
            } else {
                r = m - 1
            }
        }

        return res
    }
}
