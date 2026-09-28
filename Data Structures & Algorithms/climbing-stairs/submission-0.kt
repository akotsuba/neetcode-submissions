class Solution {
    fun climbStairs(n: Int): Int {
        if (n <= 2) return n

        var prev1 = 2
        var prev2 = 1

        repeat(n - 2) {
            val temp = prev1
            prev1 = prev1 + prev2
            prev2 = temp
        }

        return prev1
    }
}
