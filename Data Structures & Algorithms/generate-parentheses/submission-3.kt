class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()

        fun backtrack(opened: Int, closed: Int, current: String) {
            if (opened == n && closed == n) {
                result.add(current)
                return
            }

            if (opened > n) return
            if (closed > n) return
            if (closed > opened) return

            
            backtrack(opened + 1, closed, current + "(")
            backtrack(opened, closed + 1, current + ")")
        }

        backtrack(0, 0, "")

        return result
    }
}
