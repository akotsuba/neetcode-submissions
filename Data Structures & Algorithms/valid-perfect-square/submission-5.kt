class Solution {
    fun isPerfectSquare(num: Int): Boolean {
        if (num == 1) return true

        var l = 0L
        var r = num.toLong() / 2

        val numL = num.toLong()

        while (l <= r) {
            val m = l + (r - l) / 2
            val sq = m.toLong() * m
            

            when {
                sq == numL -> return true
                numL > sq -> l = m + 1
                else -> r = m - 1
            }
        }

        return false
    }
}
