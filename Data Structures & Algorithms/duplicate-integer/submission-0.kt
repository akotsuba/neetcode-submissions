class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val numsMap = HashMap<Int, Int>()
        nums.forEach {
            if (numsMap[it] != null) {
                return true
            }

            numsMap[it] = it
        }

        return false
    }
}
