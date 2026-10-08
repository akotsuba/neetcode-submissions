class Solution {
    fun maxNumberOfBalloons(text: String): Int {
        val count = HashMap<Char, Int>()

        for (c in text) {
            count[c] = count.getOrDefault(c, 0) + 1
        }

        return minOf(
            count['b'] ?: 0, 
            count['a'] ?: 0, 
            (count['l'] ?: 0) / 2, 
            (count['o'] ?: 0) / 2, 
            count['n'] ?: 0
        )
    }
}