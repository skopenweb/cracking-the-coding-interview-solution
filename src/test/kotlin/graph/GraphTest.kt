package graph

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GraphTest {
    @Test
    fun routeBetweenTwoNodes() {
        val nodes = Array(6) {
            GraphNode(it)
        }
        val edgeNodes = arrayOf(
            EdgeNode(to = 1, next = EdgeNode(to = 3)),
            null,
            EdgeNode(to = 0),
            EdgeNode(to = 2),
            EdgeNode(to = 3),
            EdgeNode(to = 4),
        )
        val g = Graph(nodes, edgeNodes)

        assertTrue(graph_4_1_bfs_route(g, 0, 1))
        assertFalse(graph_4_1_bfs_route(g, 3, 5))
        assertTrue(graph_4_1_bfs_route(g, 2, 0))
        assertFalse(graph_4_1_bfs_route(g, 4, 5))
        assertTrue(graph_4_1_bfs_route(g, 5, 4))
        assertTrue(graph_4_1_bfs_route(g, 4, 0))
        assertTrue(graph_4_1_bfs_route(g, 5, 1))
    }
}