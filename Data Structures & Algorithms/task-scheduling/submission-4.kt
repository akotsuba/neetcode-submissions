class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val count = IntArray(26)
        for (task in tasks) {
            count[task - 'A']++
        }

        val maxHeap = PriorityQueue<Int>(reverseOrder()) // most frequent
        for (c in count) {
            if (c > 0) maxHeap.add(c)
        }

        val cooldownQueue = ArrayDeque<Pair<Int, Int>>() // count of task left + time when we can use it next

        var time = 0

        while (cooldownQueue.isNotEmpty() || maxHeap.isNotEmpty()) {
            time++

            // check queue
            if (cooldownQueue.isNotEmpty() && cooldownQueue.first().second == time) {
                val task = cooldownQueue.removeFirst()
                maxHeap.add(task.first)
            }

            if (maxHeap.isNotEmpty()) {
                val curFreq = maxHeap.poll()
                if (curFreq > 1) {
                    cooldownQueue.add(curFreq - 1 to time + n + 1)
                }
            }
        }

        return time
    }
}
