class Solution {
    fun check(nums: IntArray): Boolean {
        var pivotStartIndex = -1

        for (i in 1 until nums.size) {
            if (nums[i] < nums[i - 1]) {
                if (pivotStartIndex != -1) {
                    return false
                }
                pivotStartIndex = i
            }
        }

        if (pivotStartIndex != -1) {
            for (i in 0 until pivotStartIndex) {
                val indexToCompare = if (i == 0) nums.size - 1 else i - 1
                if (nums[i] < nums[indexToCompare]) {
                    return false
                }
            }
        } 
        

        return true
    }
}