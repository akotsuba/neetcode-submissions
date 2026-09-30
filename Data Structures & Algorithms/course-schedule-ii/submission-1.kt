class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val graph = Array(numCourses) { mutableListOf<Int>() } 

        for (prereq in prerequisites) {
            graph[prereq[0]].add(prereq[1])
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
}
