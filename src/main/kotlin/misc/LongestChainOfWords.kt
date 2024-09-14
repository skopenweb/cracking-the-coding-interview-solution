package misc


class TrieNode {
    val map: MutableMap<Char, TrieNode> = mutableMapOf()
    var wordIndex: Int = -1

    fun insert(s: String, index: Int) {
        var curr = this
        if (s.isEmpty()) return
        for (c in s) {
            var next = curr.map[c]
            if (next == null) {
                next = TrieNode()
            }
            curr.map[c] = next
            curr = next
        }
        curr.wordIndex = index
    }
}

fun findMaxLen(root: TrieNode, values: Array<String>): List<String> {
    val maxList = mutableListOf<String>()
    val curr = mutableListOf<String>()
    find(root, curr, maxList, values)
    return maxList
}

fun find(n: TrieNode, currList: List<String>, maxList: MutableList<String>, values: Array<String>) {
    for ((k, v) in n.map) {
        if (v.wordIndex == -1) {
            find(v, listOf(), maxList, values)
        } else {
            val newList = mutableListOf<String>().apply {
                addAll(currList)
                add(values[v.wordIndex])
            }
            if (newList.size > maxList.size) {
                maxList.clear()
                maxList.addAll(newList)
            }
            find(v, newList, maxList, values)
        }
    }
}

fun main(args: Array<String>) {
    val root = TrieNode()
    val arr = arrayOf("a", "de", "abc", "den", "ben", "dent")
    for (i in 0..<arr.size) {
        root.insert(arr[i], i)
    }
    val ans = findMaxLen(root, arr)
    ans.forEach {
        println("$it ")
    }
    println()
}