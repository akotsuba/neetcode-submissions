class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        var result = mutableListOf<List<Int>>()
        if (numRows == 0) return result

        result.add(listOf(1))
        if (numRows == 1) return result
        
        result.add(listOf(1, 1))

        for (i in 3..numRows) {
            val row = mutableListOf<Int>()
            row.add(1)

            val prev = result[i - 2]
            for (j in 1 until i - 1) {
                println("i = $i j = $j")
                row.add(prev[j - 1] + prev[j])
            }
            row.add(1)

            result.add(row)
        }

        return result
    }
}
