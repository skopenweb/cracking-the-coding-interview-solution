package misc.contest418

import java.util.*

class Q2Method {
    fun remainingMethods(n: Int, k: Int, invocations: Array<IntArray>): List<Int> {
        val adj = Array(n) { mutableListOf<Int>() }
        invocations.forEach { edge ->
            adj[edge[0]].add(edge[1])
        }
        val visited = IntArray(n) { 0 } // -1 : error, 1 : good
        doBfs(k, adj, visited)

        var result = true

        for (i in visited.indices) {
            if (visited[i] != -1) {
                result = result && checkViaBfs(i, adj, visited)
            }
        }
        return if (result) {
            (0..<n).map { it }
        } else {
            (0..<n).filter { it != -1 }
        }
    }

    fun doBfs(k: Int, adj: Array<MutableList<Int>>, visited: IntArray) {
        val q = LinkedList<Int>()
        q.offer(k)

        while (q.isNotEmpty()) {
            val e = q.poll()
            visited[e] = -1

            adj[e].forEach { num ->
                if (visited[num] != -1) {
                    q.offer(num)
                }
            }
        }
    }

    fun checkViaBfs(k: Int, adj: Array<MutableList<Int>>, visited: IntArray): Boolean {
        val q = LinkedList<Int>()
        q.offer(k)

        while (q.isNotEmpty()) {
            val e = q.poll()
            if (visited[e] == -1) {
                return false
            }
            visited[e] = 1

            adj[e].forEach { num ->
                if (visited[num] != 1) {
                    q.offer(num)
                }
            }
        }
        return true
    }
}

fun main() {
    Q2Method().remainingMethods(
        4, 1, arrayOf(
            intArrayOf(1, 2),
            intArrayOf(0, 1),
            intArrayOf(3, 2)
        )
    )
}