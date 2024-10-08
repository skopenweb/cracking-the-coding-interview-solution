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
    val lsp = lsp(p)

    var i = 0
    var j = 0

    while (i < s.length) {
        if (j == p.length) {
            matches.add(i - p.length)
            j = 0
        }
        if (s[i] == p[j]) {
            i++
            j++
        } else {
            j = lsp[j]
            i++
        }
    }
    if (j == p.length) matches.add(i - p.length)
    return matches
}

fun lsp(s: String): IntArray {
    val lsp = IntArray(s.length) { 0 }
    var i = 0
    var j = 1
    var len = 0
    while (j < s.length) {
        if (s[i] == s[j]) {
            lsp[j] = ++len
            j++
            i++
        } else {
            if (len > 0) {
                i = 0
                len = 0
            } else {
                lsp[j++] = 0
            }
        }
    }
    return lsp
}

fun main() {
    val text = "AABAACAADAABAABA"
    val pattern = "AABA"

    val ans = bruteForcePatternMatch(text, pattern)
    //ans.prettyPrint()

    val ans2 = KMPSearch(text, pattern)
    //ans2.prettyPrint()

    val s = "aaaabab"
    //lsp(s).prettyPrint()

    lsp("AAAA").prettyPrint()
    lsp("ABCDE").prettyPrint()
    lsp("AABAACAABAA").prettyPrint()
    lsp("AAACAAAAAC").prettyPrint()
    lsp("AAABAAA").prettyPrint()
}