class Solution {
    fun countSeniors(details: Array<String>): Int {
        var result = 0
        for (detail in details) {
            if (detail[11] > '6' || (detail[11] == '6' && detail[12] > '0')) {
                result++
            }
        }

        return result
    }
}
