class Solution {

    //  1) abc, ab -> impossible
    //  2) a -> b, b -> a - cycle, impossible
    fun foreignDictionary(words: Array<String>): String {
        val graph = HashMap<Char, MutableSet<Char>>()  // a -> [b, c, d ... ]
        val inDegree = HashMap<Char, Int>()

        // init structures
        for (word in words) {
            for (char in word) {
                graph.putIfAbsent(char, HashSet<Char>())
                inDegree.putIfAbsent(char, 0)
            }
        }

        // Loop throw the words

        for (i in 0 until words.size - 1) {
            val w1 = words[i]
            val w2 = words[i + 1]

            if (w1.length > w2.length && w1.startsWith(w2)) return "" // cannot be 

            val minLength = min(w1.length, w2.length)
            for (j in 0 until minLength) {
                val c1 = w1[j]
                val c2 = w2[j]

                if (c1 != c2) {
                    if (graph[c1]?.contains(c2) == false) {
                        graph[c1]?.add(c2)
                        inDegree[c2] = (inDegree[c2] ?: 0) + 1
                    }

                    break // no need to check further  
                }
            }
        }

        // BFS

        val queue = ArrayDeque<Char>()
        for ((char, degree) in inDegree) {
            if (degree == 0) {
                queue.add(char)
            }
        }

        var result = ""

        while (queue.isNotEmpty()) {
            val char = queue.poll()

            result += char

            graph[char]?.let { deps ->
                for (dep in deps) {
                    inDegree[dep] = (inDegree[dep] ?: 0) - 1
                    if (inDegree[dep] == 0) {
                        queue.add(dep)
                    }
                }
            }
        }

        val allCharsProcessed = result.length == inDegree.size

        return if (allCharsProcessed) result else ""
    }
}
