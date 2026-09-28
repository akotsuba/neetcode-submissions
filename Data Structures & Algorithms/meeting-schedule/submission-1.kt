/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        if (intervals.size <= 1) return true 

        val sorted = intervals.sortedBy { it.start }

        for (i in 0..sorted.size - 2) {
            if (sorted[i].end > sorted[i + 1].start) {
                return false
            }
        }

        return true
    }
}
