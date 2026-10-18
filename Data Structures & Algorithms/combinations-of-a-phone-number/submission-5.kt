class Solution {
    fun letterCombinations(digits: String): List<String> {
        val map = mutableMapOf(
            2 to arrayOf('a', 'b', 'c'),
            3 to arrayOf('d', 'e', 'f'),
            4 to arrayOf('g', 'h', 'i'),
            5 to arrayOf('j', 'k', 'l'),
            6 to arrayOf('m', 'n', 'o'),
            7 to arrayOf('p', 'q', 'r', 's'),
            8 to arrayOf('t', 'u', 'v'),
            9 to arrayOf('w', 'x', 'y', 'z'),
        )

        val result = mutableListOf<String>()
        if (digits.isEmpty()) return result

        fun backtrack(index: Int, current: String) {
            if (current.length == digits.length) {
                result.add(current)
                return
            }

            val digit = digits[index] - '0'
            val chars = map[digit]!!

            for (i in 0 until chars.size) {
                backtrack(index + 1, current + chars[i].toString())
            }
        }

        backtrack(0, "")

        return result
    }
}
