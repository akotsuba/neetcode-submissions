class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val count = IntArray(26)
        for (task in tasks) {
            count[task - 'A']++
        }

        val maxHeap = PriorityQueue<Int>({ it1, it2 -> it2 - it1 })

        for (cnt in count) {
            if (cnt > 0) {
                maxHeap.offer(cnt)
            }
        }

        val queue = ArrayDeque<Pair<Int, Int>>()
        var time = 0

        while (maxHeap.isNotEmpty() || queue.isNotEmpty()) {
            time++

            if (maxHeap.isNotEmpty()) {
                val newCount = maxHeap.poll() - 1
                if (newCount != 0) {
                    queue.addLast(newCount to time + n)
                }
            } 

            if (queue.isNotEmpty() && time == queue.first().second) {
                maxHeap.offer(queue.removeFirst().first)
            }
        }

        return time
    }
}
