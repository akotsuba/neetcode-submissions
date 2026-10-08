class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        val positionsToRemove = mutableListOf<Int>()

        for (i in 0 until nums.size) {
            if (nums[i] == `val`) {
                positionsToRemove.add(i)
            }
        }

        var curShift = 0
        for (i in 0 until nums.size) {
            if (curShift < positionsToRemove.size && i == positionsToRemove[curShift]) {
                curShift++
            } else {
                nums[i - curShift] = nums[i]
                // nums[i] = null 
            }
        }

        return nums.size - positionsToRemove.size
    }
}
