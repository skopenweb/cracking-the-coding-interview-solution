package moderate

import priorityqueue.BinaryHeap
import priorityqueue.PriorityQueue
import kotlin.math.abs

fun moderate_chapter_16_1_swap(a: Int, b: Int) {
    var a1 = a
    var b1 = b

    a1 = a + b
    b1 = a1 - b

    a1 -= b1
}

class TrieNode(
    var count: Int = 0, var children: MutableMap<Char, TrieNode> = mutableMapOf()
)

internal fun addWord(root: TrieNode, w: String) {
    var curr = root
    for (c in w) {
        var next = curr.children[c]
        if (next == null) {
            next = TrieNode()
            curr.children[c] = next
        }
        curr = next
    }
    curr.count++
}

fun moderate_chapter_16_2_word_freq(texts: List<String>): Int {
    val list = java.util.LinkedList<TrieNode>()
    var max = Integer.MIN_VALUE
    val rootNode = TrieNode()
    for (w in texts) {
        addWord(rootNode, w)
    }
    list.add(rootNode)

    while (list.isNotEmpty()) {
        val curr = list.poll()
        max = max.coerceAtLeast(curr.count)
        curr?.let {
            it.children.forEach { e ->
                list.offer(e.value)
            }
        }
    }
    return max.coerceAtLeast(0)
}

class Items(val a: Int, val b: Int, val c: Int)

fun moderate_chapter_16_2_checkWinner(a: Array<IntArray>): Boolean {
    assert(a.size > 2)
    assert(a[0].size > 2)
    var c1 = 0
    var c2 = 0
    var c3 = 0
    var c4 = 0

    for (i in 0..2) {
        for (j in 0..2) {
            if (a[i][j] == 0) {
                c1++
                if (i == j) {
                    c3++
                }
                if (i + j == 2) {
                    c4++
                }
            }
        }
        for (j in 0..2) {
            if (a[j][i] == 0) {
                c2++
            }
        }

        if (c1 == 3 || c2 == 3 || c3 == 3 || c4 == 3) return true
    }
    return false
}

fun moderate_16_3_intersection(): Pair<Float, Float> {
    // TODO
    return Pair(0.0f, 0.0f)
}

fun moderate_16_5_factorial_zeros(n: Int): Int {
    var count = 0
    var num = n
    var factor: Int

    do {/*
        factor = 5, count = 1, n = 5
        factor = 1, count = 6, n = 1
        factor = 0
        * */

        factor = num / 5
        count += factor
        num /= 5
    } while (factor > 0)

    return count
}

private fun moderate_16_6_smallest_difference(a: IntArray, b: IntArray): Int {
    a.sort()
    b.sort()

    var i1 = 0
    var i2 = 0
    /*
    Input:
        {1, 2, 3, 11, 15},
        {8, 19, 23, 127, 235}
    Output: 3. That is, the pair (11, 8).
    * */
    var minDiff = Integer.MAX_VALUE
    while (i1 < a.size && i2 < b.size) {
        if (a[i1] == b[i2]) return 0
        else if (a[i1] < b[i2]) {
            minDiff = minDiff.coerceAtMost(abs(a[i1] - b[i2]))
            i1++
        } else {
            minDiff = minDiff.coerceAtMost(abs(a[i1] - b[i2]))
            i2++
        }
    }
    return minDiff
}

fun moderate_16_8_english_int(n: Int): String {
    val tokensMap = parseTokens(n)
    val names = listOf("billion", "million", "thousand", "")

    val sb = StringBuilder()

    for (name in names) {
        tokensMap[name]?.let {
            sb.append(convertNumber(it)).append(" ").append(name).append(" ")
        }
    }
    return sb.toString().trim()
}

fun convertNumber(n: Int): String {
    return if (n > 99) {
        val hundred = convertNumber(n / 100).plus(" hundred")
        val twos = convertNumber(n % 100)
        if (twos.isEmpty()) hundred else hundred.plus(" ").plus(twos)
    } else if (n > 19) {
        val ones = convertNumber(n % 10)
        if (ones.isEmpty())
            convertFrom20Till99(n)
        else
            convertFrom20Till99(n).plus(" ").plus(ones)
    } else {
        convertTill19(n)
    }
}

fun convertTill19(n: Int): String {
    require(n in 0..19)
    val numbers = listOf(
        "",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "ten",
        "eleven",
        "twelve",
        "thirteen",
        "fourteen",
        "fifteen",
        "sixteen",
        "seventeen",
        "eighteen",
        "nineteen",
    )
    return numbers[n]
}

fun convertFrom20Till99(n: Int): String {
    return when {
        n >= 90 -> "ninety"
        n >= 80 -> "eighty"
        n >= 70 -> "seventy"
        n >= 60 -> "sixty"
        n >= 50 -> "fifty"
        n >= 40 -> "forty"
        n >= 30 -> "thirty"
        n >= 20 -> "twenty"
        else -> ""
    }
}

fun parseTokens(num: Int): Map<String, Int> {
    var n = num
    val tokenMap = mutableMapOf<String, Int>()
    val names = listOf("", "thousand", "million", "billion")
    var i = 0
    while (n > 0 && i < 4) {
        val value = n % 1_000
        if (value != 0) {
            tokenMap[names[i]] = value
        }
        i++
        n /= 1_000
    }
    return tokenMap
}

data class Person(val birth: Int, val death: Int)

fun moderate_16_10_living_people(persons: List<Person>): Int {
    val sortedArr = persons.sortedWith { p1, p2 -> p1.birth - p2.birth }
    val pq = java.util.PriorityQueue<Person> { p1, p2 -> p1.death - p2.death }
    var maxSize = 0

    for (p in sortedArr) {
        if (pq.isEmpty().not()) {
            val top = pq.peek()
            if (top.death < p.birth) {
                pq.poll()
            }
        }
        pq.offer(p)
        maxSize = maxSize.coerceAtLeast(pq.size)
    }
    return maxSize
}

fun main() {
//    val text =
//        "jai sri ram jai sri ram jai sri ram jai sri ram jai sri ram jai sri ram sab maya ram jai jain rama krishna"
//    val result = moderate_chapter_16_2_word_freq(text.split(" "))
////    println(result)
//
//    println(moderate_16_5_factorial_zeros(26))
//    println(
//        moderate_16_6_smallest_difference(
//            intArrayOf(1, 3, 15, 11, 2), intArrayOf(23, 127, 235, 19, 8)
//        )
//    )
//    println(moderate_16_8_english_int(10_100))

    println(moderate_16_10_living_people(listOf(
        Person(1991, 2019),
        Person(1980, 2022),
        Person(2022, 2049),
    )))
}