class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var p1 = m - 1
        var p2 = n - 1
        var p = m + n - 1

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--]
            } else {
                nums1[p] = nums2[p2--]
            }
            p--
        }
    }
}
