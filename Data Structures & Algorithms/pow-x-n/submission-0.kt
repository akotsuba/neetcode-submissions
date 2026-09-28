class Solution {
    fun myPow(x: Double, n: Int): Double {
        
        fun helper(x: Double, n: Int): Double {
            if (n == 0) return 1.0
            if (x == 0.0) return 0.0

            val half = helper(x, n / 2)
            val extra = if (n % 2 == 0) 1.0 else x
            val res = half * half * extra

            return res
        }

        val result = helper(x, abs(n))

        return if (n < 0) {
            1.0 / result 
        } else {
            result
        }
    }
}
