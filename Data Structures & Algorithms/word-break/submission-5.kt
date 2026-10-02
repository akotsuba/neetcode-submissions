class Solution {
    /**
        1. Bruteforce - recursion 
        2. Recursion + memo (top-down)
    
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val wordSet = wordDict.toSet() 

        val memo = HashMap<Int, Boolean>()
        
        fun canBreak(start: Int): Boolean { 
            if (start == s.length) return true
            if (memo.contains(start)) return memo[start]!!

            for (end in start + 1..s.length) {
                val word = s.substring(start, end)
                
                if (word in wordSet && canBreak(end)) {
                    memo[start] = true
                    return true
                }
            }

            memo[start] = false
            return false
        }

        return canBreak(0)
    }

    */

    // BFS 

    // Bottom-up
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray(s.length + 1)
        dp[0] = true

        val wordSet = wordDict.toSet()

        for (i in 0 until s.length) {
            if (!dp[i]) continue

            for (w in wordDict) {
                if (i + w.length <= s.length && w == s.substring(i, i + w.length)) {
                    dp[i + w.length] = true
                }
            }
        }

        return dp[s.length]
    }
}
