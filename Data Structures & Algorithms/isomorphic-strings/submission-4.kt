class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val mappingST = HashMap<Char, Char>()
        val mappingTS = HashMap<Char, Char>()

        for (i in 0 until s.length) {
            if (mappingST.contains(s[i]) && mappingST[s[i]] != t[i]) {
                return false        
            } else if (mappingTS.contains(t[i]) && mappingTS[t[i]] != s[i]) {
                return false
            } else {
                mappingST[s[i]] = t[i]
                mappingTS[t[i]] = s[i]
            }
        }

        return true
    }
}
