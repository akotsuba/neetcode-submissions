class Solution {
    fun majorityElement(nums: IntArray): Int {
        val occurences = HashMap<Int, Int>()
        val minOccurence = nums.size / 2 + 1

        for (num in nums) {
            occurences[num] = occurences.getOrDefault(num, 0) + 1

            if (occurences[num] == minOccurence) {
                return num
            }
        }

        return -1
    }
}
