class WordDictionary {

    class TreeNode(
        val value: Char,
        var end: Boolean = false,
    ) {
        val children = Array<TreeNode?>(26) { null }
    }

    private val root = TreeNode('-')

    fun addWord(word: String) {
        var cur = root
        word.forEachIndexed { index, letter ->
            var node = cur.children[letter - 'a']
            if (node == null) {
                node = TreeNode(letter)
                cur.children[letter - 'a'] = node
            }

            cur = node
        }

        cur.end = true
    }

    fun search(word: String): Boolean {
        
        fun found(charIndex: Int, root: TreeNode): Boolean {
            var cur = root

            for (i in charIndex until word.length) {
                val letter = word[i]

                if (letter == '.') {
                    cur.children.forEach { child ->
                        if (child != null && found(i + 1, child)) return true
                    }

                    return false
                } else {
                    if (cur.children[letter - 'a'] == null) {
                        return false
                    } else {
                        cur = cur.children[letter - 'a']!!
                    } 
                }
            }

            return cur.end
        }

        return found(0, root)
    }

    
}
