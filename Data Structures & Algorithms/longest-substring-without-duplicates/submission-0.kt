class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = HashSet<Char>()
        var result = 0
        var firstCharIndex = 0

        for (i in 0..s.length - 1) {
            while (s[i] in set) {
                set.remove(s[firstCharIndex])
                firstCharIndex++
            }

            set.add(s[i])
            result = max(result, set.size)
        }
        
        return result
    }
}
