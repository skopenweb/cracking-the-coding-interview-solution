package misc

import java.util.*

class P2101Bomb {
    fun maximumDetonation(bombs: Array<IntArray>): Int {
        val adj = Array(bombs.size) {
            mutableListOf<Int>()
        }
        for (i in bombs.indices) {
            for (j in bombs.indices) {
                if (i != j) {
                    if (bombs[i].near(bombs[j])) {
                        adj[i].add(j)
                    }
                }
            }
        }

        var max = 0
        for (i in bombs.indices) {
            max = max.coerceAtLeast(bfs(i, bombs, adj))
        }
        return max
    }

    fun bfs(bomb: Int, bombs: Array<IntArray>, adj: Array<MutableList<Int>>): Int {
        val q = LinkedList<Int>()
        q.offer(bomb)

        val dist = IntArray(bombs.size) {
            Integer.MIN_VALUE
        }
        dist[bomb] = 1
        while (q.isNotEmpty()) {
            val b = q.poll()
            for (nearBomb in adj[b]) {
                if (dist[nearBomb] == Integer.MIN_VALUE) {
                    dist[nearBomb] = dist[b] + 1
                    q.offer(nearBomb)
                }
            }
        }
        val max = dist.count { it != Integer.MIN_VALUE }
        return max
    }

    private fun IntArray.near(o: IntArray): Boolean {
        val x = (this[0] - o[0]).toLong()
        val y = (this[1] - o[1]).toLong()
        var r = this[2].toLong()
        return (x * x + y * y) <= r * r
    }
}

fun main() {
//    val ans = P2101Bomb().maximumDetonation(
//        arrayOf(
//            intArrayOf(1, 2, 3),
//            intArrayOf(2, 3, 1),
//            intArrayOf(3, 4, 2),
//            intArrayOf(4, 5, 3),
//            intArrayOf(5, 6, 4),
//        )
//    )
    val ans2 = P2101Bomb().maximumDetonation(
        arrayOf(
            intArrayOf(1, 1, 100000),
            intArrayOf(100000, 100000, 1),
        )
    )
    println(ans2)
}