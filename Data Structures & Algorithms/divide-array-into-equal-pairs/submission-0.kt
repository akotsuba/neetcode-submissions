class Solution {
    fun divideArray(nums: IntArray): Boolean {
        val numSet = HashSet<Int>()

        for (num in nums) {
            if (numSet.contains(num)) {
                numSet.remove(num)
            } else {
                numSet.add(num)
            }
        }

        return numSet.isEmpty()
    }
}