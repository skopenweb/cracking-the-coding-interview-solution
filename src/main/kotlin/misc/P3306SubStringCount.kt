package misc

class P3306SubStringCount {
    // ieaouqqieaouqq
    //

    val vowels = "aeiou"
    val vowelIndices = vowels.indices.map { vowels[it].code }

    private fun Char.isVowel() = vowelIndices.contains(this.code)

    fun isValidFreq(arr: IntArray, k: Int): Boolean {
        var vowelCount = 0
        var consCount = 0
        for (i in arr.indices) {
            if (vowelIndices.contains(i)) {
                if (arr[i] > 0) vowelCount++
            } else {
                if (arr[i] > 0) {
                    consCount += arr[i]
                }
            }
        }
        return vowelCount == 5 && consCount == k
    }

    fun countOfSubstrings(word: String, k: Int): Long {
        // first find out a valid range l,r
        // r -> nextRight
        // l -> nextLeft

        // check the possiblity in between, count them
        // matchFound == 0, try to find by r++
        // found == 1, once l and r possibilities are exhausted, move to found = 1

        val freq = IntArray(127) { 0 }
        var count = 0
        var l = 0
        var r = 0
        var found = 0

        while (l < word.length && r < word.length) {
            if (found == 0) {
                freq[word[r].code]++
                if (isValidFreq(freq, k)) {
                    found = 1
                } else {
                    r++
                }
            } else { // match found
                val rStart = r
                var rEnd = r + 1
                while (rEnd < word.length && word[rEnd].isVowel()) {
                    rEnd++
                }

                val lStart = l
                var lEnd = l + 1
                while (lEnd < r && word[lEnd].isVowel()) {
                    lEnd++
                }

                freq[word[rStart].code]--
                var copy: IntArray
                for (i in lStart..<lEnd) {
                    copy = IntArray(127) { freq[it] }
                    for (j in rStart..<rEnd) {
                        freq[word[j].code]++
                        if (isValidFreq(freq, k)) {
                            count += (rEnd - j)
                            break
                        }
                    }
                    freq.forEachIndexed { index, _ -> freq[index] = copy[index] }
                    freq[word[i].code]--
                }
                l = lEnd
                r = rEnd
                found = 0
            }
        }
        return count.toLong()
    }
}

fun main() {
     val ans = P3306SubStringCount().countOfSubstrings("aeiouq", 1)
    val ans2 = P3306SubStringCount().countOfSubstrings("ieaouqqieaouqq", 1)
    val ans3 = P3306SubStringCount().countOfSubstrings("iqeaouqi", 2)
    println("ans = $ans")
    println("ans2 = $ans2")
    println("ans3 = $ans3")
}