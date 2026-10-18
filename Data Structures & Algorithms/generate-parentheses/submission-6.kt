class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()

        fun backtrack(opened: Int, closed: Int, current: String) {
            if (opened == n && closed == n) {
                result.add(current)
                return
            }

            if (opened < n) {
                backtrack(opened + 1, closed, current + "(")
            }

            if (closed < opened) {
                backtrack(opened, closed + 1, current + ")")
            }
        }

        backtrack(0, 0, "")

        return result
    }
}
