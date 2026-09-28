class Solution {
    fun singleNumber(nums: IntArray): Int {
        var sum = 0
        nums.forEach { num -> sum = sum xor num }
        return sum
    }
}
