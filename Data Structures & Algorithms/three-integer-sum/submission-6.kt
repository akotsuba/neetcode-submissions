class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val results = mutableListOf<List<Int>>()
        if (nums.size < 3) return results

        nums.sort()
        
        for (i in 0..nums.size - 1) {
            var a = nums[i]

            if (results.lastOrNull()?.get(0) == a) {
                continue
            }

            var l = i + 1
            var r = nums.size - 1

            while (l < r) {
                val sum = nums[l] + nums[r]
                val target = (-1) * a

                if (sum == target) {
                    results.add(listOf(a, nums[l], nums[r]))
                    
                    while (l < nums.size - 2 && nums[l + 1] == nums[l]) l++
                    while (r > 0 && nums[r - 1] == nums[r]) r--
                    
                } 
                
                if (sum > target) {
                    r--
                } else {
                    l++
                }
            }
        }

        return results
    }
}
