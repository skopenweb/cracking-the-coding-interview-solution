package graph

import org.junit.jupiter.api.Test
import tree.TreeNode
import kotlin.test.assertEquals
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

    @Test
    fun `check list of depths of tree`() {
        val n11 = TreeNode<String>("n11")
        val n12 = TreeNode<String>("n12")
        val n1 = TreeNode<String>("n1", n11, n12)

        val n21 = TreeNode<String>("n21")
        val n22 = TreeNode<String>("n22")
        val n2 = TreeNode<String>("n2", null, n22)

        val n = TreeNode(data = "n", left = n1, right = n2)

        val listOfNodesAtSameDepth = graph_4_3_list_of_depths(n)

        val l0 = listOfNodesAtSameDepth[0]
        val l1 = listOfNodesAtSameDepth[1]
        val l2 = listOfNodesAtSameDepth[2]

        assertEquals(l0, listOf("n"))
        assertEquals(l1, listOf("n1", "n2"))
        assertEquals(l2, listOf("n11", "n12", "n22"))
    }

    @Test
    fun `minimal height of tree`() {
        val arr = Array(16) { ('A'.code + it).toChar() }
        val expectedHeight = 4

        val root = graph_4_2_minimal_tree_2(arr)
        val height = height(root)

        assertEquals(height, expectedHeight)
    }

    @Test
    fun `minimal height of tree_2`() {
        val arr = Array(32) { ('A'.code + it).toChar() }
        val expectedHeight = 5

        val root = graph_4_2_minimal_tree_2(arr)
        val height = height(root)

        assertEquals(height, expectedHeight)
    }

}