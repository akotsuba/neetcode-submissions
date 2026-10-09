class Solution {
    fun mySqrt(x: Int): Int {
        var l = 0L
        var r = x + 1L

        while (l < r) {
            val m = l + (r - l) / 2
            val sq = m * m

            if (sq > x) r = m else l = m + 1
        }

        return (l - 1).toInt()
    }
}
