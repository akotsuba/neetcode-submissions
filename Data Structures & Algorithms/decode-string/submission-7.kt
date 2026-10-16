class Solution {
    fun decodeString(s: String): String {

        var i = 0

        fun helper(s: String): String {
            var k = 0
            var res = StringBuilder()

            while (i < s.length) {
                val c = s[i]

                when {
                    c.isDigit() -> k = k * 10 + (c - '0')
                    c == '[' -> {
                        i++
                        val subRes = helper(s)
                        repeat(k) { res.append(subRes) }
                        k = 0
                    }
                    c == ']' -> return res.toString()
                    else -> res.append(c)
                }

                i++
            }

            return res.toString()
        }

        return helper(s)
    }
        
}
