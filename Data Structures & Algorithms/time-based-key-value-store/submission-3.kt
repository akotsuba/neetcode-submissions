class TimeMap() {

    private val keyStore = HashMap<String, MutableList<Pair<String, Int>>>()

    fun set(key: String, value: String, timestamp: Int) {
        keyStore[key] = keyStore.getOrDefault(key, mutableListOf()).apply {
            add(value to timestamp)
        }
    }

    fun get(key: String, timestamp: Int): String {
        var result = ""
        val list = keyStore[key] ?: return result

        var l = 0
        var r = list.size - 1

        while (l <= r) {
            val m = (l + r) / 2
            if (list[m].second <= timestamp) {
                result = list[m].first
                l = m + 1
            } else {
                r = m - 1
            }
        }

        return result
    }
}
