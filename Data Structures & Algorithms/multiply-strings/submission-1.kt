class Solution {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") return "0"
        
        var result = mutableListOf<Int>()

        for (p1 in num1.length - 1 downTo 0) { 
            for (p2 in num2.length - 1 downTo 0) {
                val mult = num1[p1].toInt2() * num2[p2].toInt2()

                var position = (num1.length - 1 - p1) + (num2.length - 1 - p2)
                val multWithCarry = mult + (result.getOrNull(position) ?: 0)

                val digit = multWithCarry % 10
                var carry = multWithCarry / 10

                // println("digit = $digit carry = $carry position = $position")

                if (position < result.size) {
                    result[position] = digit
                } else {
                    result.add(digit)
                }

                while (carry != 0) {
                    position++
                    val sum = (result.getOrNull(position) ?: 0) + carry
                    val digit = sum % 10
                    carry = sum / 10

                    if (position < result.size) {
                        result[position] = digit
                    } else {
                        result.add(digit)
                    }
                }    
            } 
        }

        return result.reversed().joinToString("")
    }

    
}

fun Char.toInt2(): Int = this - '0'
