package sortingSearching

import prettyPrint

fun bruteForcePatternMatch(text: String, pattern: String): List<Int> {
    if (pattern.isEmpty()) return listOf()
    val result = mutableListOf<Int>()
    var i = 0
    while (i <= text.length - pattern.length) {
        var j = 0
        while (j < pattern.length) {
            if (text[i + j] != pattern[j]) break
            j++
        }
        if (j == pattern.length) result.add(i)
        i++
    }
    return result
}

fun KMPSearch(s: String, p: String): List<Int> {
    val matches = mutableListOf<Int>()
    val lps = lps(p)

    var i = 0 // text index
    var j = 0 // pattern

    while (i < s.length ) {
        if (s[i] == p[j]) {
            i++
            j++
        }
        if (j == p.length) {
            matches.add(i - p.length)
            j = lps[j - 1]
        } else if (i < s.length && s[i] != s[j]) {
            if (j > 0) {
                j = lps[j - 1]
            } else {
                i++
            }
        }
    }
    return matches
}

fun lps(s: String): IntArray {
    val h = IntArray(s.length) { 0 }
    var j = 0
    var i = 1
    while (i < s.length) {
        if (s[i] == s[j]) {
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

fun main() {
    val text = "AABAACAADAABAABA"
    val pattern = "AABA"

//    val ans = bruteForcePatternMatch(text, pattern)
//    //ans.prettyPrint()
//
    val ans2 = KMPSearch(text, pattern)
    ans2.prettyPrint()

//    val s = "aaaabab"
//    //lsp(s).prettyPrint()

//    lps("AAAA").prettyPrint()
//    lps("ABCDE").prettyPrint()
//    lps("AABAACAABAA").prettyPrint()
//    lps("AAACAAAAAC").prettyPrint()
//    lps("AAABAAA").prettyPrint()
}