fun main(args: Array<String>) {
    println("Cracking the coding interview")
    println("Chapter 1: Arrays and Strings")
    arrays_1_1_isUnique("abc")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

internal fun arrays_1_1_isUnique(s: String): Boolean {
    val end = s.length - 1
    var start = 0
    while (start < s.length) {
        val ch = s[start]
        var iter = end
        while (iter > start) {
            if (s[iter] == ch) return false
            iter--
        }
        start++
    }
    return true
}