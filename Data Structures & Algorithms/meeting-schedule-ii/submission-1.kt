/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        var roomsRequired = 0

        val starts = intervals.map { it.start }.sorted()
        val ends = intervals.map { it.end }.sorted()

        var startPoint = 0
        var endPoint = 0

        var currentRooms = 0

        while (startPoint < starts.size) {
            if (starts[startPoint] < ends[endPoint]) {
                currentRooms++
                roomsRequired = max(roomsRequired, currentRooms)
                startPoint++
            } else {
                endPoint++
                currentRooms--
            }
        }

        return roomsRequired
    }
}
