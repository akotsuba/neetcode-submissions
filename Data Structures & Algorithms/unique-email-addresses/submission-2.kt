class Solution {
    fun numUniqueEmails(emails: Array<String>): Int {
        val emailsSet = HashSet<String>()

        for (email in emails) {
            val normalizedEmail = normalizeEmail(email)
            println("$normalizedEmail")
            emailsSet.add(normalizedEmail)
        }

        return emailsSet.size
    }

    fun normalizeEmail(email: String): String {
        var normalized = ""
        var isDomain = false
        var isAlias = false

        for (c in email) {
            if (isDomain) {
                normalized += c
            } else {
                if (isAlias && c != '@') {
                    continue
                } else if (c == '+') {
                    isAlias = true
                } else if (c == '@') {
                    normalized += c
                    isDomain = true
                } else if (c == '.') {
                    continue
                } else {
                    normalized += c
                }
            }
        }

        return normalized
    }
}
