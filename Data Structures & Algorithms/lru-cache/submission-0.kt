class LRUCache(capacity: Int) {

    private class Node(
        val key: Int,
        val value: Int, 
        var next: Node? = null,
        var prev: Node? = null,
    )

    private val capacity = capacity
    private val cache = mutableMapOf<Int, Node>()

    private val left = Node(0, 0)  // least recent used
    private val right = Node(0, 0) // most recent

    init {
        left.next = right
        right.prev = left
    }

    fun get(key: Int): Int {
        return cache[key]?.let { node ->
            remove(node)
            insert(node)
            node.value
        } ?: -1
    }

    fun put(key: Int, value: Int) {
        // delete for the same key
        cache[key]?.let { node ->
            remove(node)
            cache.remove(node.key)
        }

        val node = Node(key, value)
        cache[key] = node
        insert(node)

        // check capacity
        if (cache.size > capacity) {
            left?.next?.let { lru ->
                remove(lru)
                cache.remove(lru.key)
            }   
        }
    }

    private fun insert(node: Node) {
        val prev = right.prev
        val next = right
        prev?.next = node
        next?.prev = node
        node.next = next
        node.prev = prev
    }

    private fun remove(node: Node) {
        val prev = node.prev
        val next = node.next
        prev?.next = next
        next?.prev = prev
    }
}
