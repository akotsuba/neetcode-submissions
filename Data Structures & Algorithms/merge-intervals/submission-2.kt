class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()

        intervals.sortedBy { it[0] }.forEach { interval ->
            if (result.isEmpty()) {
                result.add(interval)
            } else {
                val last = result.last()
                if (last[1] >= interval[0]) {
                    result[result.size - 1] = intArrayOf(last[0], maxOf(interval[1], last[1]))
                } else {
                    result.add(interval)
                }
            }
        }

        return result.toTypedArray()
    }
}
