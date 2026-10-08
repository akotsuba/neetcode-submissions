class Solution {
    fun isArraySpecial(nums: IntArray): Boolean {
        var evenExpected = nums[0] % 2 == 0

        for (num in nums) {
            if (evenExpected && num % 2 != 0) {
                return false
            } else if (!evenExpected && num % 2 == 0) {
                return false
            } else {
                evenExpected = !evenExpected
            }
        }

        return true
    }
}