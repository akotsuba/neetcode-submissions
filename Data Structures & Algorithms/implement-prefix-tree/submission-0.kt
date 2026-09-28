class PrefixTree {

    class TreeNode(
        val value: Char,
        var endOfWord: Boolean = false,    
    ) {
        val children = Array<TreeNode?>(26) { null }
    }

    private val root = TreeNode('.')

    fun insert(word: String) {
        var cur = root
        word.forEachIndexed { index, letter ->
            var node = cur.children[letter - 'a']
            if (node == null) {
                node = TreeNode(letter)
                cur.children[letter - 'a'] = node
            } 

            if (node.endOfWord == false) {
                node.endOfWord = index == word.length - 1
            }

            cur = node
        }
    }

    fun search(word: String): Boolean {
        var cur = root
        word.forEach { letter ->
            cur = cur.children[letter - 'a'] ?: return false
        }

        return cur.endOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var cur = root
        prefix.forEach { letter ->
            val node = cur.children[letter - 'a']
            if (node == null) return false
            cur = node
        }

        return true
    }
}
