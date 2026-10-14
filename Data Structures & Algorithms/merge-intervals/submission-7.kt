class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }

        val result = mutableListOf<IntArray>()
        
        for (interval in intervals) {
            if (result.isEmpty()) {
                result.add(interval)
            } else {
                val lastInterval = result.last()
                if (lastInterval[1] >= interval[0]) {
                    result[result.size - 1] = intArrayOf(lastInterval[0], maxOf(lastInterval[1], interval[1]))
                } else {
                    result.add(interval)
                }
            }
        }

        return result.toTypedArray()
    }
}
