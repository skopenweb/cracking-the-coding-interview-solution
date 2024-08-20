package graph

import queues.QueueImpl
import tree.TreeNode
import tree.TreeNodeWithParent
import java.util.LinkedList
import kotlin.math.abs

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

fun graph_4_2_minimal_tree(n: Int): TreeNode<Int>? {
    if (n == 0) return null

    val arr = IntArray(n) { it + 1 }
    val n = createTree(arr, 0, n - 1)
    return n
}

internal fun createTree(arr: IntArray, low: Int, high: Int): TreeNode<Int>? {
    if (low == high) return TreeNode(low)
    if (low > high) return null

    val s = high - low + 2
    var k = 1
    while (k <= s) {
        k *= 2
    }
    k /= 2

    val mid = low + (k - 1)
    val l = createTree(arr, low, mid - 1)
    val r = createTree(arr, mid + 1, high)

    return TreeNode(arr[mid], l, r)
}

fun <T> graph_4_2_minimal_tree_2(array: Array<T>): TreeNode<T>? {
    if (array.isEmpty()) return null

    return makeMinimalTree(array, 0, array.size - 1)
}

fun <T> makeMinimalTree(arr: Array<T>, low: Int, high: Int): TreeNode<T>? {
    if (low > high) return null
    val mid = (low + high + 1) / 2

    val left = makeMinimalTree(arr, low, mid - 1)
    val right = makeMinimalTree(arr, mid + 1, high)

    return TreeNode(data = arr[mid], left = left, right = right)
}

internal fun <T> graph_4_3_list_of_depths(node: TreeNode<T>): List<List<T>> {
    val ll = LinkedList<List<T>>()

    val q = QueueImpl<TreeNode<T>>()
    q.enqueue(node)
    var currCount = 1
    var nextCount = 0

    var l = LinkedList<T>()

    while (q.isEmpty().not()) {
        val d = q.dequeue()
        l.add(d.data)
        arrayOf(d.left, d.right).forEach {
            it?.let {
                nextCount++
                q.enqueue(it)
            }
        }
        currCount--
        if (currCount == 0) {
            ll.add(l)
            l = LinkedList<T>()
            currCount = nextCount
            nextCount = 0
        }
    }
    return ll
}

internal fun <T> graph_4_4_checkBalancedTree(node: TreeNode<T>?): Pair<Boolean, Int> {
    if (node == null) return Pair(true, -1)

    val left = graph_4_4_checkBalancedTree(node.left)
    val right = graph_4_4_checkBalancedTree(node.right)

    if (left.first || right.first) return Pair(false, -1)

    val lh = left.second
    val rh = right.second

    val difference = abs(lh - rh)
    return if (difference < 2) {
        Pair(true, 1 + lh.coerceAtLeast(rh))
    } else {
        Pair(false, -1)
    }
}

internal fun <T : Comparable<T>> graph_4_5_validateBST(root: TreeNode<T>): Boolean {
    val rootResult = validateBinarySearchTree(root)
    return rootResult.result
}

class NodeResult<T>(val result: Boolean, val min: T? = null, val max: T? = null)

internal fun <T : Comparable<T>> validateBinarySearchTree(node: TreeNode<T>?): NodeResult<T> {
    if (node == null) return NodeResult(true)

    val leftResult = validateBinarySearchTree(node.left)
    if (leftResult.result.not()) return NodeResult(false)

    val rightResult = validateBinarySearchTree(node.right)
    if (rightResult.result.not()) return NodeResult(false)

    if (leftResult.max != null && leftResult.max > node.data) {
        return NodeResult(false)
    } else if (rightResult.min != null && rightResult.min < node.data) {
        return NodeResult(false)
    }
    var min = node.data
    var max = node.data
    leftResult.min?.let {
        min = it
    }
    rightResult.max?.let {
        max = it
    }
    return NodeResult(true, min, max)
}

internal fun <T : Comparable<T>> graph_4_6_successor(node: TreeNodeWithParent<T>?): TreeNodeWithParent<T>? {
    if (node?.parent == null) return null
    node.right?.let {
        var next: TreeNodeWithParent<T> = it
        while (next.left != null) {
            next = next.left!!
        }
        return next
    }
    var curr = node
    var p = curr.parent
    while (p != null && p.left == curr) {
        curr = p
        p = p.parent
    }
    return p
}

fun main() {
}

fun testRoute() {
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

internal fun createFullTree(arr: IntArray, low: Int, high: Int): TreeNode<Int>? {
    if (low == high) return TreeNode(low)
    if (low > high) return null

    val mid = (high - low + 1) / 2
    val l = createFullTree(arr, low, mid - 1)
    val r = createFullTree(arr, mid + 1, high)

    return TreeNode(arr[mid], l, r)
}

internal fun <T> height(root: TreeNode<T>?): Int {
    if (root == null) return -1
    val leftHeight = height(root.left)
    val rightHeight = height(root.right)

    return leftHeight.coerceAtLeast(rightHeight) + 1
}