class Solution {
    fun isHappy(n: Int): Boolean {
        val visited = HashSet<Int>()
        var currentValue = n

        while (currentValue !in visited) {
            visited.add(currentValue)
            currentValue = sumOfSquares(currentValue)

            if (currentValue == 1) {
                return true
            }
        }

        return false
    }

    fun sumOfSquares(n: Int): Int {
        var sumOfSquares = 0
        var currentValue = n

        while (currentValue > 0) {
            val digit = currentValue % 10
            currentValue = currentValue / 10

            sumOfSquares += digit * digit
        }

        return sumOfSquares
    }
}
