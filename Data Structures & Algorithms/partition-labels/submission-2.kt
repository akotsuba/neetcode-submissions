class Solution {
    fun partitionLabels(s: String): List<Int> {

        val endsMap = HashMap<Char, Int>()

        for (i in 0 until s.length) {
            endsMap[s[i]] = i
        }

        var currStart = 0
        var currEnd = 0
        var result = mutableListOf<Int>()

        for (i in 0 until s.length) {
            val newEnd = endsMap[s[i]] ?: -1

            if (newEnd > currEnd) {
                currEnd = newEnd
            }

            if (i == currEnd) {
                result.add(currEnd - currStart + 1)

                currStart = i + 1
            }
        }

        return result
    }
}
