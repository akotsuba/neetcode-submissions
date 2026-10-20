class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: MutableList<String>): Int {
        val wordSet = wordList.toHashSet()
        var result = 1

        if (endWord !in wordSet) return 0

        val visited = HashSet<String>()

        val queue = ArrayDeque<String>() 
        queue.add(beginWord)
        visited.add(beginWord)

        while (queue.isNotEmpty()) {
            val itemsPerLevel = queue.size

            repeat(itemsPerLevel) {
                val curWord = queue.removeFirst()

                if (curWord == endWord) return result

                val curChars = curWord.toCharArray()

                for (i in curChars.indices) {
                    val curChar = curChars[i]

                    for (c in 'a'..'z') {
                        if (curChar == c) continue

                        curChars[i] = c
                        val stringModified = String(curChars)
                        if (stringModified in wordSet && stringModified !in visited) {
                            queue.add(stringModified)
                            visited.add(stringModified)
                        }
                    }

                    curChars[i] = curChar
                }
            }

            result++
        }

        return 0
    }
}
