class MyHashSet() {

    private val bucketsSize = 10007 // prime numbers are better to distribute unique hashes
    private val buckets = Array<MutableList<Int>?>(bucketsSize) { null }

    fun add(key: Int) {
        val index = hash(key)
        if (buckets[index] == null) {
            buckets[index] = mutableListOf()
        }

        if (buckets[index]?.contains(key) == false) { // IMPORTANT!
            buckets[index]?.add(key)
        }
    }

    fun remove(key: Int) {
        val index = hash(key)
        val bucket = buckets[index]
        bucket?.remove(key)
    }

    fun contains(key: Int): Boolean {
        val index = hash(key)
        val bucket = buckets[index]
        return bucket?.contains(key) == true
    }

    private fun hash(key: Int): Int {
        return key % bucketsSize
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */
