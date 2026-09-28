class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val numsSet = HashSet<Int>()
        nums.forEach {
            if (numsSet.contains(it)) {
                return true
            }

            numsSet.add(it)
        }

        return false
    }
}
