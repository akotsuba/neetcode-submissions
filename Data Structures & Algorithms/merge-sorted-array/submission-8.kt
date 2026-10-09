class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var i1 = m - 1
        var r1 = m + n - 1
        var i2 = n - 1

        while (i2 >= 0) {
            if (i1 == -1) {
                nums1[r1--] = nums2[i2--]
            } else if (nums1[i1] > nums2[i2]) {
                nums1[r1--] = nums1[i1--]
            } else {
                nums1[r1--] = nums2[i2--]
            }
        }
    }
}
