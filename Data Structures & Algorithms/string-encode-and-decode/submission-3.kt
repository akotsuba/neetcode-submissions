class Solution {

    fun encode(strs: List<String>): String {
        if (strs.size == 0) return ""
        
        val result = StringBuilder()

        result.append(strs.map { it.length }.joinToString(",") + "#")
        strs.forEach {
           result.append(it) 
        }

        return result.toString()
    }

    fun decode(str: String): List<String> {
        if (str.isEmpty()) return listOf()

        val result = mutableListOf<String>()

        val lengthsSeparationIndex = str.indexOf('#')
        val sizes = str
            .substring(0, lengthsSeparationIndex)
            .split(",")
            .map { it.toInt() }

        var strIndex = lengthsSeparationIndex + 1
        sizes.forEach { size ->
            val subString = str.substring(strIndex, strIndex + size)
            result.add(subString)
            strIndex += size
        }

        return result
    }
}
