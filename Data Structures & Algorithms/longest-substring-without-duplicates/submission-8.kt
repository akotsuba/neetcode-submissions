class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var l = 0
        val charSet = HashSet<Char>()
        var maxLen = 0

        for (r in s.indices) {
            while (s[r] in charSet) {
                charSet.remove(s[l])
                l++
            }
            charSet.add(s[r])

            maxLen = maxOf(maxLen, charSet.size)
        }

        return maxLen
    }
}
