class Solution {
    fun generateParenthesis(n: Int): List<String> {
        if (n == 0) return listOf()

        var result = mutableListOf<String>()
        var cur = ""

        fun backtrack(opened: Int, closed: Int) {
            if (cur.length == n * 2) {
                result.add(cur)
                return
            }

            if (opened < n) {
                cur += "("
                backtrack(opened + 1, closed)
                cur = cur.substring(0, cur.length - 1)
            }

            if (closed < opened) {
                cur += ")"
                backtrack(opened, closed + 1)
                cur = cur.substring(0, cur.length - 1)
            }
        }

        backtrack(0, 0)

        return result
    }
}
