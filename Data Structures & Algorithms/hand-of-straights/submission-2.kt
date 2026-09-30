class Solution {

    // O(nlog(n))
    // O(k) - for hashmap
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size % groupSize != 0) return false

        val countMap = TreeMap<Int, Int>()

        for (card in hand) {
            countMap[card] = countMap.getOrDefault(card, 0) + 1
        }

        for ((card, count) in countMap) {
            if (count > 0) {
                for (i in 0 until groupSize) {
                    val nextCard = card + i
                    val nextCardCount = countMap.getOrDefault(nextCard, 0)

                    if (nextCardCount < count) {
                        return false
                    }

                    countMap[nextCard] = nextCardCount - count
                }
            }
        }

        return true
    }
}
