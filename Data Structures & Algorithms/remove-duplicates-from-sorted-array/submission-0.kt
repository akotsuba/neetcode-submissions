class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var ins = 1
        var cur = 1

        while (cur < nums.size) {
            if (nums[cur] != nums[cur - 1]) {
                nums[ins++] = nums[cur]
            } 
            cur++
        }

        return ins
    }
}
