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

    /* Bottom-up
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray(s.length + 1)
        dp[0] = true

        // val wordSet = wordDict.toSet()

        for (i in 0 until s.length) {
            if (!dp[i]) continue

            for (w in wordDict) {
                if (i + w.length <= s.length && s.regionMatches(i, w, 0, w.length)) {
                    dp[i + w.length] = true

                    if (i + w.length == s.length) return true
                }
            }
        }

        return dp[s.length]
    }
    */

    /* Bottom-up suffix check + no hashset

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray(s.length + 1)
        dp[s.length] = true

        for (i in s.length - 1 downTo 0) {
            for (word in wordDict) {
                if (i + word.length <= s.length && s.substring(i, i + word.length) == word) {
                    dp[i] = dp[i + word.length]
                }

                if (dp[i]) break
            }
        }

        return dp[0]
    }
    */

    // Bottom-up with trie

    class TrieNode {
        val children: MutableMap<Char, TrieNode> = mutableMapOf<Char, TrieNode>()
        var isWord = false
    }

    class Trie {

        val root = TrieNode()

        fun insert(word: String) {
            var cur = root

            for (c in word) {
                cur = cur.children.computeIfAbsent(c) { TrieNode() }
            }

            cur.isWord = true
        }

        fun search(s: String, i: Int, j: Int): Boolean {
            var cur = root

            for (idx in i..j) {
                val char = s[idx]
                cur = cur?.children[char] ?: return false
            }

            return cur.isWord
        }
    }

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        
        val trie = Trie()

        for (word in wordDict) {
            trie.insert(word)
        }

        val dp = BooleanArray(s.length + 1)
        dp[s.length] = true
        
        val maxWordLen = wordDict.maxOfOrNull { it.length } ?: 0 // or count in trie?

        for (i in s.length - 1 downTo 0) {
            val maxEnd = min(s.length, i + maxWordLen)

            for (j in i until maxEnd) {
                if (trie.search(s, i, j)) {
                    println("found i = $i j = $j")

                    dp[i] = dp[j + 1]
                    if (dp[i]) break
                }
            }
        }

        return dp[0]
    }

}
