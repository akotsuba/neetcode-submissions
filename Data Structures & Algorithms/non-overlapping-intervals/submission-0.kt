class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[0] }

        var result = 0
        var prevEnd = intervals[0][1]

        for (i in 1..intervals.size - 1) {
            if (intervals[i][0] >= prevEnd) {
                prevEnd = intervals[i][1]
            } else {
                prevEnd = min(prevEnd, intervals[i][1])
                result++
            }
        }

        return result
    }
}
