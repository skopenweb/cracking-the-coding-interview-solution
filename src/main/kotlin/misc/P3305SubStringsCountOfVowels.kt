package misc

class P3305SubStringsCountOfVowels {

    val vowels = "aeiou"
    val vowelIndices: List<Int> = vowels.indices.map { vowels[it].code }

    fun countOfSubstrings(word: String, k: Int): Int {
        var count = 0
        for (i in 0..<word.length) {
            for (j in i..<word.length) {
                if (isValid(word, i, j, k)) count++
            }
        }
        return count
    }

    fun isValid(word: String, l: Int, r: Int, k: Int): Boolean {
        val freq = IntArray(127)
        var consonants = 0
        for (c in l..r) {
            freq[word[c].code]++
            if (vowelIndices.contains(word[c].code).not()) {
                consonants++
            }
        }
        if (consonants != k) return false
        var result = true
        for (index in vowelIndices) {
            result = result && (freq[index] > 0)
        }
        return result
    }
}

fun main() {
    val ans = P3305SubStringsCountOfVowels().countOfSubstrings("ieaouqqieaouqq", 1)
    println("ans = $ans")
}