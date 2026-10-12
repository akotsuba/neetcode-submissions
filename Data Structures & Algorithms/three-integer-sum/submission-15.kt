class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort() // O(nlogn)

        val result = mutableListOf<List<Int>>()

        for (i in 0 until nums.size - 2) {
            var l = i + 1
            var r = nums.size - 1

            if (nums[i] > 0) break
            if (i > 0 && nums[i] == nums[i - 1]) continue

            while (l < r) {
                val sum = nums[i] + nums[l] + nums[r]

                when {
                    sum == 0 -> {
                        result.add(listOf(nums[i], nums[l], nums[r]))
                        l++
                        r--
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++
                        }
                    }
                    sum > 0 -> r--
                    else -> l++
                }
            }
        }

        return result
    }
}
