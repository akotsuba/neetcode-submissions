class Solution {
    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""

        var start = 0
        var end = 0

        fun getPalindromeLength(left: Int, right: Int): Int {
            var l = left
            var r = right

            while (l >= 0 && r < s.length && s[l] == s[r]) {
                l--
                r++
            }

            return r - l - 1
        }

        for (i in 0 until s.length) {
            val l1 = getPalindromeLength(i, i)
            val l2 = getPalindromeLength(i, i + 1)

            val maxLen = maxOf(l1, l2)

            if (maxLen > end - start + 1) {
                start = i - (maxLen - 1) / 2
                end = i + maxLen / 2
            }
        }
        
        return s.substring(start, end + 1)
    }
}
