class Solution {
    // TODO: optimize the necessity to scan map every time

    fun characterReplacement(s: String, k: Int): Int {
        val repeats = HashMap<Char, Int>()
        var result = 0
        var l = 0

        for (r in s.indices) {
            repeats[s[r]] = (repeats.getOrDefault(s[r], 0)) + 1
            

            val maxFreq = repeats.values.max()

            while (r - l - maxFreq >= k) {
                repeats[s[l]] = repeats.getOrDefault(s[l], 1) - 1
                l++
            }

            result = max(result, r - l + 1)
        }

        return result
    }
}
