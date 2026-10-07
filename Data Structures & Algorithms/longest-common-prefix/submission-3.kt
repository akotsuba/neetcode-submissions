class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 0 || strs[0].length == 0) return ""
        
        for (i in strs[0].indices) {
            val char = strs[0][i]

            for (str in strs) {
                if (i >= str.length) {
                    return if (i == 0) "" else strs[0].substring(0, i)
                }
                if (str[i] != char) {
                    return if (i == 0) "" else strs[0].substring(0, i)
                }
            }   
        }

        return strs[0]
    }
}
