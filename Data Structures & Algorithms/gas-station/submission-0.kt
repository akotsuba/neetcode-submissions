class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var startStation = 0

        var totalGas = 0
        var currentGas = 0

        for (i in 0 until gas.size) {
            val gasDiff = gas[i] - cost[i]

            totalGas += gasDiff

            currentGas += gasDiff

            if (currentGas < 0) {
                startStation = i + 1
                currentGas = 0
            }
        }

        return if (totalGas >= 0) startStation else -1
    }
}
