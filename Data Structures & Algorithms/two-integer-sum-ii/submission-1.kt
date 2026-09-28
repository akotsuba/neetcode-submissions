class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        if (numbers.size == 0) return intArrayOf()

        var start = 0
        var end = numbers.size - 1
        while (start < end) {
            val sum = numbers[start] + numbers[end]
            if (sum == target) {
                return intArrayOf(start + 1, end + 1)
            } else if (sum > target) {
                end--
            } else {
                start++
            }
        }

        return intArrayOf()
    }
}
