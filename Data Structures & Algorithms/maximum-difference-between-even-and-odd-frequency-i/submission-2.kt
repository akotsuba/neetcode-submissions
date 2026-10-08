class Solution {
    fun maxDifference(s: String): Int {
        val counts = IntArray(26)

        for (c in s) {
            counts[c - 'a']++
        }

        var maxOdd = 0
        var minEven = s.length

        for (count in counts) {
            if (count != 0 && count % 2 != 0) maxOdd = maxOf(maxOdd, count)  
            if (count != 0 && count % 2 == 0) minEven = minOf(minEven, count)  
        }

        return maxOdd - minEven
    }
}
