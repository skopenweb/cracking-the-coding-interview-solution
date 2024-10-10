package misc

class P3303Substring {
    fun minStartingIndex(s: String, p: String): Int {
        val result = intArrayOf(Integer.MAX_VALUE)
        find(s, p, 0, 0, true, result)
        return result[0]
    }

    fun find(s: String, p: String, i: Int, j: Int, allow: Boolean, result: IntArray) {
        if (j == p.length) {
            result[0] = result[0].coerceAtMost(i - j)
            return
        }
        if (i >= s.length) return
        if (s.length - i < p.length - j) return
        if (result[0] < i - j) return
        if (s[i] == p[j]) {
            find(s, p, i + 1, j + 1, allow, result)
        } else {
            if (allow) find(s, p, i + 1, j + 1, false, result)
            else return
        }
        if (j == 0) find(s, p, i + 1, j, allow, result)
    }
}

fun main() {
    val result = P3303Substring().minStartingIndex("ababbababa", "bacaba")
    println(result)
}