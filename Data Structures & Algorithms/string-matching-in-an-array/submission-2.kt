class Solution {
    fun stringMatching(words: Array<String>): List<String> {
        var result = mutableSetOf<String>()
        for (word in words) {
            for (w in words) {
                if (w != word && word.contains(w)) {
                    result.add(w)
                }
            }
        }

        return result.toList()
    }
}
