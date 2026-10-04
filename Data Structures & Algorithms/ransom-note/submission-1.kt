class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val charCount = IntArray(26)

        for (c in magazine) {
            charCount[c - 'a']++
        }

        for (c in ransomNote) {
            if (--charCount[c - 'a'] < 0) return false
        }

        return true
    }
}
