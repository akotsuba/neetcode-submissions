class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val map = HashMap<Char, String>()
        val map2 = HashMap<String, Char>() 
        val words = s.split(" ")

        if (pattern.length != words.size) return false

        for (i in 0 until pattern.length) {
            val c = pattern[i]
            if (map.contains(c) && map[c] != words[i]) {
                return false
            } else if (map2.contains(words[i]) && map2[words[i]] != c) {
                return false
            } else {
                map[c] = words[i]
                map2[words[i]] = c
            }
        }

        return true
    }
}