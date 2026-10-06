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

    fun put(key: Int, value: Int) {
        if (cache.contains(key)) {
            val node = cache[key]!!
            remove(node)
            cache.remove(key)
        }

        val node = Node(key, value)
        add(node)
        cache[key] = node

        if (cache.size > capacity) {
            val lru = left.next
            lru?.let {
                remove(it)
                cache.remove(it.key)
            }
        }
    }

    fun get(key: Int): Int {
        val node = cache[key]

        if (node == null) {
            return -1
        } else {
            remove(node)
            add(node)

            return node.value
        }
    } 

    private fun remove(node: Node) {
        val left = node.prev
        val right = node.next
        left?.next = right
        right?.prev = left
    }

    private fun add(node: Node) {
        val left = right.prev
        val right = right
        node?.prev = left
        node?.next = right
        left?.next = node
        right?.prev = node
    }

}
