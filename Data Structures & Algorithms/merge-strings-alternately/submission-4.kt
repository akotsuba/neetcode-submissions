class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        var s = ""

        var l1 = 0
        var l2 = 0

        while (l1 < word1.length || l2 < word2.length) {
            if (l1 < word1.length) {
                s += word1[l1++]
            }
            if (l2 < word2.length) {
                s += word2[l2++]
            }
        }

        return s
    }
}
