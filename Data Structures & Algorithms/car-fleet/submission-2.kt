class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        if (position.size == 0) return 0

        val fleets = ArrayDeque<Float>()

        val positionSpeedPair = position
            .zip(speed)
            .sortedByDescending { it.first }

        for (i in 0..positionSpeedPair.size - 1) {
            val time: Float = (target - positionSpeedPair[i].first).toFloat() / positionSpeedPair[i].second.toFloat()

            if (fleets.size != 0) {
                val lastCarTime = fleets.peek()
                if (time > lastCarTime) {
                    fleets.push(time)
                }
            } else {
                fleets.push(time)
            }
        }

        return fleets.size
    }
}
