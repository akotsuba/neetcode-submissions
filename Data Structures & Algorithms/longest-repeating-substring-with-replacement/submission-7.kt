class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val count = mutableMapOf<Char, Int>()
        var l = 0 
        var maxFreq = 0
        var res = 0

        for (r in 0 until s.length) {
            count[s[r]] = count.getOrDefault(s[r], 0) + 1
            maxFreq = max(maxFreq, count[s[r]]!!)

            while (r - l + 1 - maxFreq > k) {
                count[s[l]] = count[s[l]]!! - 1
                l++
            }

            res = maxOf(res, r - l + 1)
        }

        return res
    }
}
