class Solution {
    fun validWordAbbreviation(word: String, abbr: String): Boolean {
        var i = 0
        var j = 0

        while (i < word.length && j < abbr.length) {
            var digit = ""

            if (abbr[j] == '0') return false

            while (j < abbr.length && abbr[j].isDigit()) {
                digit += abbr[j]
                j++
            }
            
            if (digit.isNotEmpty()) {
                val d = digit.toInt()
                // println("i = $i d = $d")
                // if (i + d > word.length) {
                //     return false
                // }
                i += d
            } else if (word[i] != abbr[j]) {
                return false    
            } else {
                i++
                j++
            }

            println("i = $i j = $j")
        }

        return i == word.length && j == abbr.length
    }
}
