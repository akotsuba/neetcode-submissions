class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        if (cost.size == 1) return cost[0]
        if (cost.size == 2) return min(cost[0], cost[1])
        
        var r2 = cost[cost.size - 1]
        var r1 = cost[cost.size - 2]
        for (i in cost.size - 3 downTo 0) {
            val temp = r1
            r1 = min(cost[i] + r1, cost[i] + r2)
            r2 = temp
        }

        return min(r1, r2)
    }
}
