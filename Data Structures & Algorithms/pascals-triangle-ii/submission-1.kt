class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        if (rowIndex == 0) return listOf(1)

        val prevRow = getRow(rowIndex - 1)
        val row = mutableListOf<Int>()
        row.add(1)
        for (i in 1 until prevRow.size) {
            row.add(prevRow[i - 1] + prevRow[i])
        }
        row.add(1)

        return row
    }
}