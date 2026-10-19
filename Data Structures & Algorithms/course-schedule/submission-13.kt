class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {

        val prereqMap = mutableMapOf<Int, MutableList<Int>>() // course -> prereq
        val indegree = IntArray(numCourses) { 0 }

        for (pr in prerequisites) { // 0 1 c p
            val course = pr[0]
            val prereq = pr[1]

            prereqMap.computeIfAbsent(prereq) {
                mutableListOf<Int>()
            }.add(course)
            indegree[course]++
        }

        println("$prereqMap")

        val queue = ArrayDeque<Int>()
        for (n in 0 until numCourses) {
            if (indegree[n] == 0) {
                queue.add(n)
            }
        }

        var coursesCompleted = 0
        while (queue.isNotEmpty()) {
            val u = queue.poll()
            println("processing $u")
            coursesCompleted++

            if (prereqMap.contains(u)) {
                for (v in prereqMap[u]!!) {
                    indegree[v]--

                    if (indegree[v] == 0) {
                        queue.add(v)
                    }
                }
            }
        }

        return numCourses == coursesCompleted
    }
}
