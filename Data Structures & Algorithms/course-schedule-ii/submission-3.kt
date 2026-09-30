class Solution {
    /* With DFS O(V+E) / O(V+E)


    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val graph = Array(numCourses) { mutableListOf<Int>() } 

        for (prereq in prerequisites) {
            val course = prereq[0]
            val prerequisit = prereq[1]

            graph[course].add(prerequisit) // course -> [prereq]
            // graph[prerequisit].add(course) // prereq -> [course] - breaks the ordering but the answer is correct
        }

        val visited = Array(numCourses) { 0 } // 0 1 2
        val answer = mutableListOf<Int>()

        fun hasCycle(course: Int): Boolean {
            if (visited[course] == 1) return true
            if (visited[course] == 2) return false

            visited[course] = 1

            for (depCourse in graph[course]) {
                if (hasCycle(depCourse)) {
                    return true
                }
            }

            visited[course] = 2
            answer.add(course)

            return false
        }

        for (i in 0 until numCourses) {
            if (hasCycle(i)) return intArrayOf()
        }

        return answer.toIntArray()
    }
    */

    // BFS (Kahn's Algorithm) O(V+E) O(V+E)

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val graph = Array(numCourses) { mutableListOf<Int>() }

        val inDegrees = IntArray(numCourses) // the amount of in-directed edges per node

        for (prereq in prerequisites) {
            val (course, prereq) = prereq
            graph[prereq].add(course)  // prereq -> [course]

            inDegrees[course]++
        }

        val queue = ArrayDeque<Int>()

        for (course in 0 until numCourses) {
            if (inDegrees[course] == 0) {
                queue.add(course)
            }
        }

        val result = IntArray(numCourses)
        var index = 0

        while (queue.size > 0) {
            
            val course = queue.poll()
            result[index++] = course

            // println("course = $course")

            for (next in graph[course]) {
                inDegrees[next]--

                // println("inDegrees for $next is ${inDegrees[next]}")
                if (inDegrees[next] == 0) {
                    queue.add(next)
                }
            }
        }

        return if (index == numCourses) result else intArrayOf()
    }
}
