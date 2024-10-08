package misc

import prettyPrint

class P210CoursesTopology {

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val adjacencyList = List<MutableList<Int>>(numCourses) { mutableListOf<Int>() }
        for (edge in prerequisites) {
            adjacencyList[edge[0]].add(edge[1])
        }

        var result = mutableListOf<Int>()
        val visited = IntArray(numCourses) { -1 } // -1 undiscovered, 0 discovered, 1 visited
        for (i in 0..<numCourses) {
            if (visited[i] == -1) {
                traverse(i, adjacencyList, visited, result)
            }
        }
        val order = IntArray(result.size) { result[it] }
        return order
    }

    fun traverse(i: Int, adjacency: List<List<Int>>, visited: IntArray, result: MutableList<Int>) {
        visited[i] = 0
        for (e in adjacency[i]) {
            if (visited[e] == -1) {
                visited[e] = 0
                traverse(e, adjacency, visited, result)
            }
        }
        visited[i] = 1
        result.add(i)
    }
}

fun main() {
    println("topology sort")
    val preq0 = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(2, 0),
        intArrayOf(3, 1),
        intArrayOf(3, 2),
    )
    val preq = arrayOf(intArrayOf(0, 1))
    val ans = P210CoursesTopology().findOrder(2, preq)
    ans.prettyPrint()
}

