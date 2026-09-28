class CountSquares {

    private val pointsMap = HashMap<Pair<Int, Int>, Int>()

    fun add(point: IntArray) {
        val pair = point[0] to point[1]
        pointsMap[pair] = pointsMap.getOrDefault(pair, 0) + 1    
    }

    fun count(point: IntArray): Int {
        var sum = 0
        for ((p, amount) in pointsMap) {
            if (abs(point[0] - p.first) == abs(point[1] - p.second) && point[0] != p.first && point[1] != p.second) {
                val pointCandidate1 = point[0] to p.second
                val pointCandidate2 = p.first to point[1]

                // println("${point[0]} ${point[1]} $p")
                // println("$pointCandidate1 $pointCandidate2")

                sum += pointsMap.getOrDefault(pointCandidate1, 0) * pointsMap.getOrDefault(pointCandidate2, 0) * amount
            }
        }

        return sum
    }
}
