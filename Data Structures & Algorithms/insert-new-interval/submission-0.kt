class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        var mergedInterval = newInterval
        val result = mutableListOf<IntArray>()

        for (i in 0..intervals.size - 1) {
            val interval = intervals[i]

            if (mergedInterval[1] < interval[0]) {
                result.add(mergedInterval)
                result.addAll(intervals.slice(i until intervals.size))
                return result.toTypedArray()
            } else if (mergedInterval[0] > interval[1]) {
                result.add(interval) 
            } else {
                mergedInterval = intArrayOf(
                    min(mergedInterval[0], interval[0]),
                    max(mergedInterval[1], interval[1])
                )
            }
        }

        result.add(mergedInterval)

        return result.toTypedArray()
    }
}
