class Solution {
    /* Cycle detection, topological sort. O(V + E) (courses + deps)
        
        !!! DO we have cycle? 

        0 - unvisited
        1 - visiting
        2 - visited
    */


    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {

        // course -> list of dependent
        val graph = Array(numCourses) { mutableListOf<Int>() }

        for (pr in prerequisites) {
            val course = pr[0]
            val prereq = pr[1]
            graph[prereq].add(course)
        }

        val states = IntArray(numCourses) // 0 1 2
        
        fun hasCycle(course: Int): Boolean {
            if (states[course] == 1) return true  // has cycle
            if (states[course] == 2) return false // already checked - no cycle!

            states[course] = 1

            for (nextCourse in graph[course]) {
                if (hasCycle(nextCourse)) {
                    return true
                }
            }

            states[course] = 2
            return false
        }

        for (i in 0 until numCourses) {
            if (states[i] == 0 && hasCycle(i)) return false
        }

        return true
    }
}
