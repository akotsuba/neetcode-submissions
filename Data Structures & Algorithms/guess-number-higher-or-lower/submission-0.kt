/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return       -1 if num is higher than the picked number
 *                1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num: Int): Int
 */

class Solution : GuessGame() {
    fun guessNumber(n: Int): Int {
        var l = 0
        var r = n

        while (l < r) {
            val m = l + (r - l) / 2

            when (guess(m)) {
                0 -> return m
                1 -> l = m + 1
                else -> r = m - 1
            }
        }

        return l
    }
}
