class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false 
        return getCharsAmountMap(s) == getCharsAmountMap(t)
    }

    fun getCharsAmountMap(s: String): Map<Char, Int> {
        val charsAmountMap = HashMap<Char, Int>()
        s.forEach { char ->
            charsAmountMap[char] = (charsAmountMap[char] ?: 0) + 1
        }

        return charsAmountMap
    }
}
