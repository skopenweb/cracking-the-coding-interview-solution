package graph

import queues.QueueImpl


/**
 * Adjacency list:
 **/
class GraphNode<T>(val data: T)

class EdgeNode(
    val to: Int,
    val weight: Int = 1,
    val next: EdgeNode? = null
)

class Graph<T>(val nodes: Array<GraphNode<T>>, val edgeNodes: Array<EdgeNode?>)


fun <T> graph_4_1_bfs_route(g: Graph<T>, start: T, end: T): Boolean {
    val size = g.nodes.size
    val visited = BooleanArray(size)

    val startIndex = g.nodes.indexOfFirst { it.data == start }
    val endIndex = g.nodes.indexOfFirst { it.data == end }

    if (startIndex == -1 || endIndex == -1) throw IllegalAccessException("start end data is not found")
    if (startIndex == endIndex) return true

    val queueSource = QueueImpl<Int>().apply {
        enqueue(startIndex)
    }

    while (queueSource.isEmpty().not()) {
        val s = queueSource.dequeue()
        visited[s] = true

        var n1 = g.edgeNodes[s]
        while (n1 != null) {
            if (n1.to == endIndex) return true
            if (visited[n1.to].not()) {
                queueSource.enqueue(n1.to)
            }
            n1 = n1.next
        }
    }
    return false
}

fun main() {
    val nodes = Array(6) {
        GraphNode(it)
    }
    val edgeNodes = arrayOf(
        EdgeNode(to = 1, next = EdgeNode(to = 3)),
        null,
        EdgeNode(to = 0),
        EdgeNode(to = 2, next = EdgeNode(5)),
        EdgeNode(to = 3),
        EdgeNode(to = 4),
    )
    val g = Graph(nodes, edgeNodes)

    println(graph_4_1_bfs_route(g, 0, 1))
    println(graph_4_1_bfs_route(g, 3, 5))
    println(graph_4_1_bfs_route(g, 2, 0))
    println(graph_4_1_bfs_route(g, 4, 5))
    println(graph_4_1_bfs_route(g, 5, 4))
}