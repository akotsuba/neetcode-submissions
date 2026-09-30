class Solution {

    // O(n)
    fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
        var foundX = false
        var foundY = false
        var foundZ = false

        val (x, y, z) = target

        for (triplet in triplets) {
            val (curX, curY, curZ) = triplet

            if (curX > x || curY > y || curZ > z) continue

            if (curX == x) foundX = true
            if (curY == y) foundY = true
            if (curZ == z) foundZ = true

            if (foundX && foundY && foundZ) return true
        }

        return false
    }
}
