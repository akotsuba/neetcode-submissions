class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var zeroStreak = 1
        var result = 0

        for (i in flowerbed.indices) {
            val bed = flowerbed[i]

            if (bed == 0) {
                zeroStreak++

                if (i == flowerbed.size - 1) {
                    zeroStreak++
                }

                if (zeroStreak == 3) {
                    result++
                    zeroStreak = 1
                }
            } else {
                zeroStreak = 0
            }
        }

        return result >= n
    }
}
