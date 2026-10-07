class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        var maxElement = arr[arr.size - 1]
        arr[arr.size - 1] = -1

        for (i in arr.size - 2 downTo 0) {
            val newMaxElement = max(maxElement, arr[i])
            arr[i] = maxElement
            maxElement = newMaxElement
        }

        return arr
    }
}
