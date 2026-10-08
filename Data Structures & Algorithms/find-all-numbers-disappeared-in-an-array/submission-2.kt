class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val expected = (1..nums.size).toSet()
        val current = nums.toSet()

        return (expected - current).toList()
    }
}
