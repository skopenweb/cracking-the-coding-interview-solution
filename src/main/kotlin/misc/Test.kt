package misc

/**
 * There is an undirected tree with n nodes labeled from 0 to n - 1, and rooted at node 0. You are given a 2D integer array edges of length n - 1, where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
 *
 * A node is good if all the subtrees rooted at its children have the same size.
 * Return the number of good nodes in the given tree.
 * A subtree of treeName is a tree consisting of a node in treeName and all of its descendants.
 *
 * Example 1:
 * Input: edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]
 * Output: 7
 *
 * Example 2:
 * Input: edges = [[0,1],[1,2],[2,3],[3,4],[0,5],[1,6],[2,7],[3,8]]
 * Output: 6
 *
 * Example 3:
 * Input: edges = [[0,1],[1,2],[1,3],[1,4],[0,5],[5,6],[6,7],[7,8],[0,9],[9,10],[9,12],[10,11]]
 * Output: 12
 */
class Test {

    fun countGoodNodes(edges: Array<IntArray>): Int {
        val visitedNodes = BooleanArray(edges.size + 1)
        var goodNodes = 0
        edges.forEachIndexed { index, e ->
            if (visitedNodes[index].not()) {
                val p = findGoodNodes(edges, e[0], visitedNodes)
                println("good nodes connected with ${e[0]} is ${p.first}")
                goodNodes += p.first
            }
        }
        return goodNodes
    }

    fun findGoodNodes(edges: Array<IntArray>, node: Int, v: BooleanArray): Pair<Int, Int> {
        v[node] = true
        val childSizeList = mutableListOf<Int>()
        var currGoodNodeCount = 0
        edges.forEachIndexed { _, e ->
            if ((e[0] == node) && v[e[1]].not()) {
                val p = findGoodNodes(edges, e[1], v)
                currGoodNodeCount += p.first
                childSizeList.add(p.second)
            } else if ((e[1] == node) && v[e[0]].not()) {
                val p = findGoodNodes(edges, e[0], v)
                currGoodNodeCount += p.first
                childSizeList.add(p.second)
            }
        }
        var isGoodNode = true
        var currChildSizes = 0
        childSizeList.forEach {
            isGoodNode = isGoodNode && (it == childSizeList[0])
            currChildSizes += it
        }
        if (isGoodNode) {
            currGoodNodeCount++
        }
        return Pair(currGoodNodeCount, currChildSizes + 1)
    }
}

fun convert(inputString: String): Array<IntArray> {

    val trimmedString = inputString.removeSurrounding("[", "]")
    val pairs = trimmedString.split("],[").map { it.trim() }

    // Convert each pair string to IntArray
    val arrayOfIntArrays: Array<IntArray> = pairs.map { pair ->
        // Remove any surrounding brackets and split by comma
        val elements = pair.removeSurrounding("[", "]").split(",").map { it.trim().toInt() }
        // Convert to IntArray
        elements.toIntArray()
    }.toTypedArray()

    return arrayOfIntArrays
}

fun main() {
    val input1 = "[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]"
    val input2 = "[0,1],[1,2],[2,3],[3,4],[0,5],[1,6],[2,7],[3,8]"
    val input3 = "[0,1],[1,2],[1,3],[1,4],[0,5],[5,6],[6,7],[7,8],[0,9],[9,10],[9,12],[10,11]"
    val input = "[6,0],[1,0],[5,1],[2,5],[3,1],[4,3]"
//    println("result = ${Test().countGoodNodes(convert(input1))}")
//    println("result = ${Test().countGoodNodes(convert(input2))}")
//    println("result = ${Test().countGoodNodes(convert(input3))}")
    println("result = ${Test().countGoodNodes(convert(input))}")
}
