package misc

import java.util.*

class P3302LexiSequence {

    // s : text
    // p: pattern


    fun lps(p: String): IntArray {
        val h = IntArray(p.length) { 0 }
        var i = 1
        var j = 0
        while (i < p.length) {
            if (p[i] == p[j]) {
                h[i++] = ++j
            } else {
                if (j > 0) {
                    j = h[j - 1]
                } else {
                    h[i++] = 0
                }
            }
        }
        return h
    }


    fun KmpSearch(s: String, p: String): IntArray {
        val h = lps(p)
        var i = 0
        var j = 0

        val matches = mutableListOf<Int>()

        while (i < s.length) {
            if (s[i] == p[j]) {
                i++
                j++
                if (j == p.length) {
                    matches.add(i - p.length)
                    j = h[j - 1]
                }
            } else {
                if (j > 0) {
                    j = h[j - 1]
                } else {
                    i++
                }
            }
        }
        return IntArray(matches.size) { matches[it] }
    }

    fun validSequence(word1: String, word2: String): IntArray {
        val final = Stack<Int>()
        find(word1, word2, 0, 0, true, Stack<Int>(), final)
        return IntArray(final.size) {
            final[it]
        }
    }

    // 0, 1, 2
    fun Stack<Int>.compare(o: Stack<Int>): Int {
        if (o.isEmpty()) return -1
        var i = 0
        var j = 0
        while (i < this.size && j < o.size) {
            if (this[i] != o[j]) {
                return this[i] - o[j]
            }
            i++
            j++
        }
        return 0
    }

    fun find(w: String, p: String, i: Int, j: Int, allow: Boolean, curr: Stack<Int>, finalResult: Stack<Int>) {
        if (curr.size == p.length) {
            if (curr.compare(finalResult) < 0) {
                finalResult.clear()
                finalResult.addAll(curr)
            }
            return
        }
        if (curr.compare(finalResult) > 0) {
            return
        }
        if (i >= w.length) return

        if (w[i] == p[j]) {
            curr.push(i)
            find(w, p, i + 1, j + 1, allow, curr, finalResult)
            curr.pop()
        } else {
            if (allow) {
                curr.push(i)
                find(w, p, i + 1, j + 1, false, curr, finalResult)
                curr.pop()
            }
        }
        find(w, p, i + 1, j, allow, curr, finalResult)
    }
}

fun main() {
    val ans = P3302LexiSequence().validSequence("zzabc", "ab")
    ans.forEach { print(it) }
}