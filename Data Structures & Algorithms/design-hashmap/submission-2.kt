class MyHashMap() {

    class Entry(
        val key: Int, 
        var value: Int,
    )

    val size = 10007
    val buckets = Array<MutableList<Entry>?>(10007) { null }

    fun put(key: Int, value: Int) {
        val index = getHash(key)
        if (buckets[index] == null) {
            buckets[index] = mutableListOf<Entry>()
        }

        val bucket = buckets[index]!!
        val existedEntry = bucket.find { it.key == key }
        if (existedEntry != null) {
            existedEntry.value = value
        } else {
            bucket.add(Entry(key, value))
        }
    }

    fun get(key: Int): Int {
        val index = getHash(key)
        val bucket = buckets[index] ?: return -1
        return bucket.find { it.key == key }?.value ?: -1
    }

    fun remove(key: Int) {
        val index = getHash(key)
        val bucket = buckets[index] ?: return

        bucket.removeAll { it.key == key }
    }

    fun getHash(key: Int): Int {
        return key % size
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */
