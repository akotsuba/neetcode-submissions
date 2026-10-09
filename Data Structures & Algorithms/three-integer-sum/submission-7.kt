class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val maxFirstIndex = nums.size - 3

        val result = mutableListOf<List<Int>>()

        var i = 0
        while (i <= maxFirstIndex) {
            if (nums[i] > 0) break // impossible to get 0 if the least is > 0

            if (i > 0 && nums[i] == nums[i - 1]) {
                i++
                continue
            } 

            var l = i + 1
            var r = nums.size - 1

            println("i = $i l = $l r = $r")

            while (l < r) {
                val sum = nums[i] + nums[l] + nums[r]

                when {
                    sum == 0 -> {
                        result.add(listOf(nums[i], nums[l], nums[r]))

                        while (l < r && nums[l] == nums[l + 1]) l++ // skip equal values 
                        while (l < r && nums[r] == nums[r - 1]) r-- // skip equal values 

                        l++
                        r--
                    }
                    sum < 0 -> l++
                    sum > 0 -> r--
                }
            }

            i++
        }

        return result
    }
}
