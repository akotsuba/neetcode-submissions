class Solution {
    fun heightChecker(heights: IntArray): Int {
        val heightsCount = IntArray(101)

        for (height in heights) {
            heightsCount[height]++
        }

        val expected = mutableListOf<Int>()

        for (i in 1..heightsCount.size - 1) {
            repeat(heightsCount[i]) {
                expected.add(i)
            }
        }

        println("expected = $expected")

        var mismatches = 0
        for (i in 0 until heights.size) {
            if (heights[i] != expected[i]) {
                mismatches++
            }
        }

        return mismatches
    }
}