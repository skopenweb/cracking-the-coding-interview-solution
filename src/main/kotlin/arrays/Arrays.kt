import kotlin.math.abs

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

fun arrays_1_2_checkPermutation(a: String, b: String): Boolean {
    if (a.length != b.length) return false

    val freqArrayA = getFreq(a)
    val frequencyB = getFreq(b)
    return freqArrayA == frequencyB
}

private fun getFreq(s: String): Map<Char, Int> {
    val freq = mutableMapOf<Char, Int>()
    for (c in s) {
        freq[c] = freq.getOrDefault(c, 0) + 1
    }
    return freq
}

fun arrays_1_3_URLify(s: String): String {
    val urlifiedSpace = "%20"
    val sb = StringBuilder()
    s.forEach { ch ->
        if (ch == ' ') {
            sb.append(urlifiedSpace)
        } else {
            sb.append(ch)
        }
    }
    return sb.toString()
}

fun arrays_1_3_URLify_using_arrray(s: String): String {
    val urlifiedSpace = "%20"
    val chArray = CharArray(s.length * 3)
    var j = 0
    for (c in s) {
        if (c == ' ') {
            chArray[j] = '%'
            chArray[j + 1] = '2'
            chArray[j + 2] = '0'
            j += 3
        } else {
            chArray[j++] = c
        }
    }
    return String(chArray, 0, j)
}

fun arrays_1_4_palindromic_permutation(s: String): Boolean {
    val freqFlag = BooleanArray(27) {
        false
    }
    for (c in s) {
        if ('a'.code <= c.code && c.code <= 'z'.code) {
            freqFlag[c.code - 'a'.code] = freqFlag[c.code - 'a'.code].not()
        } else if ('A'.code <= c.code && c.code <= 'Z'.code) {
            freqFlag[c.code - 'A'.code] = freqFlag[c.code - 'A'.code].not()
        }
    }
    var count = 0
    for (value in freqFlag) {
        if (value) {
            count++
            if (count > 1) break
        }
    }
    return count < 2
}

fun arrays_1_5_oneAway(s1: String, s2: String): Boolean {
    val diffLength = s1.length - s2.length

    if (abs(diffLength) > 1) return false

    val charArray1 = if (diffLength >= 0) s1.toCharArray() else s2.toCharArray()
    val charArray2 = if (diffLength >= 0) s2.toCharArray() else s1.toCharArray()

    return if (diffLength == 0) {
        checkEqualsOrReplaceScenario(charArray1, 0, charArray2, 0)
    } else {
        checkRemoveScenario(charArray1, 0, charArray2, 0)
    }
}

internal fun checkEqualsOrReplaceScenario(
    c1: CharArray, index1: Int, c2: CharArray, index2: Int
): Boolean {
    assert(index1 > -1)
    assert(index1 > -1)
    if (index1 >= c1.size) return true
    val newIndex1 = index1 + 1
    val newIndex2 = index2 + 1
    return if (c1[index1] == c2[index2]) {
        checkEqualsOrReplaceScenario(c1, newIndex1, c2, newIndex2)
    } else {
        checkEqualsScenario(c1, newIndex1, c2, newIndex2)
    }
}

internal fun checkEqualsScenario(
    c1: CharArray, index1: Int, c2: CharArray, index2: Int
): Boolean {
    if (index1 >= c1.size) return true
    val newIndex1 = index1 + 1
    val newIndex2 = index2 + 1
    return if (c1[index1] == c2[index2]) checkEqualsScenario(c1, newIndex1, c2, newIndex2)
    else false
}

internal fun checkRemoveScenario(c1: CharArray, index1: Int, c2: CharArray, index2: Int): Boolean {
    if (index1 >= c1.size || index2 >= c2.size) return true
    return if (c1[index1] != c2[index2]) {
        checkEqualsScenario(c1, index1 + 1, c2, index2)
    } else {
        checkRemoveScenario(c1, index1 + 1, c2, index2 + 1)
    }
}

fun arrays_1_6_string_Compression(input: String): String {
    val sb = StringBuilder()

    var prev: Char = input[0]
    var count = 1
    for (i in 1..<input.length) {
        val curr = input[i]
        if (curr.uppercaseChar() == prev.uppercaseChar()) {
            count++
        } else {
            sb.append(prev).append(count)
            count = 1
            prev = curr
        }
    }
    sb.append(prev).append(count)

    val compressed = sb.toString()
    return if (compressed.length >= input.length) input else compressed
}

fun arrays_1_7_rotate_matrix(matrix: Array<IntArray>): Array<IntArray> {
    val row = matrix.size
    val col = matrix[0].size
    val rotatedMatrix = Array(row) { IntArray(col) }

    for (j in 0..<col) {
        for (i in 0..<row) {
            rotatedMatrix[j][row - 1 - i] = matrix[i][j]
        }
    }
    return rotatedMatrix
}

fun arrays_1_7_rotate_matrix_in_place(matrix: Array<IntArray>) {
    if (matrix.size < 2 || matrix[0].size < 2) {
        return
    }
    val size = matrix.size
    for (i in 0 until size / 2) {
        for (j in i until size - i - 1) {
            val t = matrix[i][j]
            matrix[i][j] = matrix[size - 1 - j][i]
            matrix[size - 1 - j][i] = matrix[size - 1 - i][size - 1 - j]
            matrix[size - 1 - i][size - 1 - j] = matrix[j][size - 1 - i]
            matrix[j][size - 1 - i] = t
        }
    }
}

internal fun arrays_1_8_zero_matrix(matrix: Array<IntArray>) {
    if (matrix.isEmpty()) return
    val rowZeros = BooleanArray(matrix.size)
    val colZeros = BooleanArray(matrix[0].size)

    matrix.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { colIndex, item ->
            if (item == 0) {
                rowZeros[rowIndex] = true
                colZeros[colIndex] = true
            }
        }
    }
    matrix.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { colIndex, _ ->
            if (rowZeros[rowIndex] || colZeros[colIndex]) {
                matrix[rowIndex][colIndex] = 0
            }
        }
    }
}

fun arrays_1_9_string_rotation() {
    
}

