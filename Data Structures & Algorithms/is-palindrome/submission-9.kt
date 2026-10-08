class Solution {
    fun isPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length - 1

        while (l < r) {
            while(!s[l].isLetterOrDigit() && l < r) {
                l++
            }

            while (!s[r].isLetterOrDigit() && l < r) {
                r--
            }

            if (l == r) break

            if (s[l].lowercase() != s[r].lowercase()) return false
            l++
            r--
        }

        return true
    }
}
