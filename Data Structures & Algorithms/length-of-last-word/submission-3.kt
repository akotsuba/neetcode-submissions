class Solution {
    fun lengthOfLastWord(s: String): Int {
        var index = s.length - 1

        while (index >= 0 && s[index] == ' ') {
            index--
        }

        var end = index

        while (index >= 0 && s[index] != ' ') {
            index--
        }

        return end - index
    }
}
