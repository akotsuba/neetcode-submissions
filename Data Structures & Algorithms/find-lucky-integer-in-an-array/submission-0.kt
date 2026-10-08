class Solution {
    fun findLucky(arr: IntArray): Int {
        val occurences = HashMap<Int, Int>()

        for (num in arr) {
            occurences[num] = occurences.getOrDefault(num, 0) + 1
        }

        var lucky = -1
        for ((num, occ) in occurences) {
            if (num == occ) {
                lucky = max(lucky, num)
            }
        }

        return lucky
    }
}
