package misc


class P76MinWindowSubString {
    fun minWindow(s: String, t: String): String {
        if (t.isEmpty()) return ""

        val freq = IntArray(127) { 0 }

        for (element in t) {
            freq[element.code]++
        }

        var l = 0
        var r = 1

        var ansL = 0
        var ansR = 0

        freq[s[l].code]--

        var minLen = Int.MAX_VALUE

        while (l < s.length || r < s.length) {
            if (freq.all { it <= 0 }) {
                //print("${if (r<s.length) s[r] else "\\0"}")
                if (minLen > r-l) {
                    minLen = minLen.coerceAtMost(r - l)
                    ansL = l
                    ansR = r
                }
                freq[s[l].code]++
                l++
            } else {
                if (r == s.length) break
                freq[s[r].code]--
                r++
            }
        }

        val sb = StringBuilder()
        for (i in ansL..<ansR) {
            sb.append(s[i])
        }
        return sb.toString()
    }
}

fun main() {
    val s = "cabwefgewcwaefgcf"
    val t = "cae"
    val ans = P76MinWindowSubString().minWindow(s, t)
    println(ans)
}