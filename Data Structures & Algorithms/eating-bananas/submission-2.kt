class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        val maxK = piles.max()

        var l = 1
        var r = maxK

        while (l < r) {
            

            val m = l + (r - l) / 2

            

            val totalHours = piles.sumOf { (it + m - 1) / m }

            println("$m $l $r $totalHours")

            if (totalHours <= h) {
                r = m
            } else {
                l = m + 1    
            }
        }

        return l
    }
}
