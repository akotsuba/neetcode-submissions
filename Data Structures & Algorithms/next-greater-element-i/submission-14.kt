class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val greaterThen = HashMap<Int, Int>() // value : next greater

        val stack = ArrayDeque<Int>()
        for (num in nums2) {
            while (stack.isNotEmpty() && num > stack.last()) {
                val lessNum = stack.removeLast()
                greaterThen[lessNum] = num
            }

            stack.add(num)
        }

        val result = IntArray(nums1.size) { -1 }
        for (i in 0 until nums1.size) {
            result[i] = greaterThen.getOrDefault(nums1[i], -1)
        }

        return result
    }
}
