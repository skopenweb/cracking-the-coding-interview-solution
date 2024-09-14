package misc

import java.util.*

class P1376InformAllEmp {
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        val map = hashMapOf<Int, MutableList<Int>>()
        for (i in 0..<n) {
            map.getOrPut(manager[i]) { mutableListOf(i) }.add(i)
        }
        var res = 0
        var time = informTime[headID]
        var queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.offer(Pair(headID, informTime[headID]))
        while (queue.isEmpty().not()) {
            val curr = queue.poll()
            map[curr.first]?.forEach {
                val currTime = curr.first + curr.second
                res = res.coerceAtLeast(currTime)
                queue.offer(Pair(it, currTime))
            }
        }
        return time
    }
}

    fun main() {
        val manager = intArrayOf(2, 2, -1, 2, 2, 2)
        val inform = intArrayOf(0, 0, 1, 0, 0, 0)

        val ans = P1376InformAllEmp().numOfMinutes(6, 2, manager, inform)
        println("ans =  $ans")
    }