class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val result = HashMap<List<Int>, MutableList<String>>()

        strs.forEach { str ->
            val strKey = MutableList(26) { 0 }
            str.forEach { char -> 
                val index = char - 'a'
                strKey[index] = (strKey[index] ?: 0) + 1
            }

            val keyMatchStrings = result[strKey] ?: mutableListOf<String>()
            keyMatchStrings.add(str)
            result[strKey] = keyMatchStrings
        }

        return result.values.toList()
    }
}
