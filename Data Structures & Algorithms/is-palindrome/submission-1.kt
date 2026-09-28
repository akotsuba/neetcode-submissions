class Solution {
    fun isPalindrome(s: String): Boolean {

        val st = s.filter {it.isLetterOrDigit()}.lowercase()

        println(st)

        if (st.length <= 1) return true
       var start = 0
       var end = st.length - 1

       while (start < end) {
         if (st[start] != st[end]) {
            return false
         }

         start++
         end--
       }

       return true
    }
}
