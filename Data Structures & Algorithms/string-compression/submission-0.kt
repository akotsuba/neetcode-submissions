class Solution {
    fun compress(chars: CharArray): Int {
        var i = 0
        var write = 0
        
        while (i < chars.size) {
            val currentChar = chars[i]
            var count = 0
            
            while (i < chars.size && chars[i] == currentChar) {
                i++
                count++
            }
            
            chars[write++] = currentChar
            
            if (count > 1) {
                for (digit in count.toString()) {
                    chars[write++] = digit
                }
            }
        }
        
        return write
    }
}
