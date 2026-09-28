class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val differencesMap = HashMap<Int, Int>()

        nums.forEachIndexed { i, num ->
            val difference = target - num

            val requiredDiffIndex = differencesMap[num]
            if (requiredDiffIndex != null) {
                return intArrayOf(requiredDiffIndex, i)
            }

            differencesMap[difference] = i
        }

        return intArrayOf()
    }
}
