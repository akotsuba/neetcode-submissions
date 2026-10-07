class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.length > t.length) return false
        if (s.isEmpty()) return true

        var sIndex = 0    
        for (c in t) {
            if (c == s[sIndex]) {
                sIndex++
            }

            if (sIndex == s.length) return true
        }

        return false
    }
}
