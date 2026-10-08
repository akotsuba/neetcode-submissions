class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val numToIndexMap = HashMap<Int, Int>()
        for (i in 0 until nums1.size) {
            numToIndexMap[nums1[i]] = i
        } 

        // find next greater element
        val nextGreater = IntArray(nums1.size) { -1 }

        val stack = ArrayDeque<Int>()

        for (num in nums2) {
            while (stack.isNotEmpty() && num > stack.last()) {
                val numToUpdateNextMax = stack.removeLast()
                val index = numToIndexMap[numToUpdateNextMax]!!
                nextGreater[index] = num
            }

            if (num in nums1) {
                stack.addLast(num)
            }
        }

        return nextGreater
    }
}
