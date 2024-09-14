package tree

class Trie() {

    var tr = "Trie"
    inner class TT() {
        fun t() = "T$tr"
    }

    fun test() {
        println("hello"+ TT().t())
    }

    private val child: MutableMap<Char, Trie> = mutableMapOf()
    private var wordEnding = false

    fun insert(word: String) {
        var curr = this
        for (w in word) {
            var next = curr.child[w]
            if (next == null) {
                next = Trie()
                curr.child[w] = next
            }
            curr = next
        }
        curr.wordEnding = true
    }

    fun search(word: String): Boolean {
        var curr = this
        for (w in word) {
            val next = curr.child[w]
            if (next == null) {
                return false
            } else {
                curr = next
            }
        }
        return curr.wordEnding
    }

    fun startsWith(prefix: String): Boolean {
        var curr = this
        for (w in prefix) {
            val next = curr.child[w]
            if (next == null) {
                return false
            } else {
                curr = next
            }
        }
        return true
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */