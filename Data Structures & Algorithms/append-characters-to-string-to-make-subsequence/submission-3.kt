class Solution {
    fun appendCharacters(s: String, t: String): Int {
        var tIndex = 0

        for (c in s) {
            if (c == t[tIndex]) {
                tIndex++
            }

            if (tIndex == t.length) return 0
        }

        return t.length - tIndex
    }
}
