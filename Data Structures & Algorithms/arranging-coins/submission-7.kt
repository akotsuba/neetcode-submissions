class Solution {

    // ar progression -> n(n + 1) / 2

    fun arrangeCoins(n: Int): Int {
        if (n <= 2) return 1

        var l = 0
        var r = n 

        while (l < r) {
            val m = l + (r - l) / 2
            val sum = m.toLong() * (m + 1) / 2

            when {
                sum > n -> r = m
                else -> l = m + 1
            }
        }

        return l - 1
    }
}
