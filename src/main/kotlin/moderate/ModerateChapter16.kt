package moderate

fun moderate_chapter_16_1_swap(a: Int, b: Int) {
    var a1 = a
    var b1 = b

    a1 = a + b
    b1 = a1 - b

    a1 -= b1
}

class TrieNode(
    var count: Int = 0,
    var children: MutableMap<Char, TrieNode> = mutableMapOf()
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

fun checkWinner(a: Array<IntArray>): Boolean {
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
                if (i+j == 2) {
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

fun main() {
    val text =
        "jai sri ram jai sri ram jai sri ram jai sri ram jai sri ram jai sri ram sab maya ram jai jain rama krishna"
    val result = moderate_chapter_16_2_word_freq(text.split(" "))
    println(result)
}