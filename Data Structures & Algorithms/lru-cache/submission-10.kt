class LRUCache(capacity: Int) {

    class Node(
        val key: Int,
        val value: Int,
        var next: Node? = null,
        var prev: Node? = null,
    )

    private val left = Node(0, 0)
    private val right = Node(0, 0)

    private val capacity = capacity
    private val cache = HashMap<Int, Node>()

    init {
        left.next = right
        right.prev = left
    }

    fun get(key: Int): Int {
        if (cache.contains(key)) {
            val node = cache[key]!!

            remove(node)
            add(node)
            return node.value
        } else {
            return -1
        }
    }

    fun put(key: Int, value: Int) {
        if (cache.contains(key)) {
            val node = cache[key]!!
            remove(node)
        }

        val node = Node(key, value)
        cache[key] = node
        add(node)

        if (cache.size > capacity) {
            val lru = left.next
            lru?.let { 
                remove(it) 
                cache.remove(it.key)
            }
        }
    }

    private fun add(node: Node) {
        val left = right.prev
        val right = right
        node.prev = left
        node.next = right
        left?.next = node
        right?.prev = node
    }

    private fun remove(node: Node) {
        val left = node.prev
        val right = node.next
        left?.next = right
        right?.prev = left
    }
}
