class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        if (ransomNote.length > magazine.length) return false

        val charsCount = IntArray(26)

        for (i in 0 until magazine.length) {
            charsCount[magazine[i] - 'a']++

            if (i < ransomNote.length) {
                charsCount[ransomNote[i] - 'a']--
            }
        }

        for (i in 0 until 26) {
            if (charsCount[i] < 0) return false
        }

        return true
    }
}
