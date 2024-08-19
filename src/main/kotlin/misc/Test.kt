//package misc
//
///**
// * There is an undirected tree with n nodes labeled from 0 to n - 1, and rooted at node 0. You are given a 2D integer array edges of length n - 1, where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
// *
// * A node is good if all the subtrees rooted at its children have the same size.
// * Return the number of good nodes in the given tree.
// * A subtree of treeName is a tree consisting of a node in treeName and all of its descendants.
// *
// * Example 1:
// * Input: edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]
// * Output: 7
// *
// * Example 2:
// * Input: edges = [[0,1],[1,2],[2,3],[3,4],[0,5],[1,6],[2,7],[3,8]]
// * Output: 6
// *
// * Example 3:
// * Input: edges = [[0,1],[1,2],[1,3],[1,4],[0,5],[5,6],[6,7],[7,8],[0,9],[9,10],[9,12],[10,11]]
// * Output: 12
// */
//class Test {
//
//    fun countGoodNodes(edges: Array<IntArray>): Int {
//        val visitedNodes = BooleanArray(edges.size + 1)
//        var goodNodes = 0
//        edges.forEachIndexed { index, e ->
//            if (visitedNodes[index].not()) {
//                val p = findGoodNodes(edges, e[0], visitedNodes)
//                println("good nodes connected with ${e[0]} is ${p.first}")
//                goodNodes += p.first
//            }
//        }
//        return goodNodes
//    }
//
//    fun findGoodNodes(edges: Array<IntArray>, node: Int, v: BooleanArray): Pair<Int, Int> {
//        v[node] = true
//        val childSizeList = mutableListOf<Int>()
//        var currGoodNodeCount = 0
//        edges.forEachIndexed { _, e ->
//            if ((e[0] == node) && v[e[1]].not()) {
//                val p = findGoodNodes(edges, e[1], v)
//                currGoodNodeCount += p.first
//                childSizeList.add(p.second)
//            } else if ((e[1] == node) && v[e[0]].not()) {
//                val p = findGoodNodes(edges, e[0], v)
//                currGoodNodeCount += p.first
//                childSizeList.add(p.second)
//            }
//        }
//        var isGoodNode = true
//        var currChildSizes = 0
//        childSizeList.forEach {
//            isGoodNode = isGoodNode && (it == childSizeList[0])
//            currChildSizes += it
//        }
//        if (isGoodNode) {
//            currGoodNodeCount++
//        }
//        return Pair(currGoodNodeCount, currChildSizes + 1)
//    }
//
//    fun convert(inputString: String): Array<IntArray> {
//
//        val trimmedString = inputString.removeSurrounding("[", "]")
//        val pairs = trimmedString.split("],[").map { it.trim() }
//
//        // Convert each pair string to IntArray
//        val arrayOfIntArrays: Array<IntArray> = pairs.map { pair ->
//            // Remove any surrounding brackets and split by comma
//            val elements = pair.removeSurrounding("[", "]").split(",").map { it.trim().toInt() }
//            // Convert to IntArray
//            elements.toIntArray()
//        }.toTypedArray()
//
//        return arrayOfIntArrays
//    }
//
//    fun countKConstraintSubstrings(s: String, k: Int): Int {
//        var i = 0
//        var j = 0
//        var c1 = 0
//        var c0 = 0
//        var count = 0
//        for (i in s.indices) {
//            j = i
//            var c1 = 0
//            var c0 = 0
//            while (j < s.length) {
//                if (s[i] == '0') c0++
//                if (s[i] == '1') c1++
//                if (c0 <= k && c1 <= k) count++
//                else break
//            }
//        }
//    }
//
//}
//
////fun maxEnergyBoost(eA: IntArray, eB: IntArray): Long {
////    val cacheA = IntArray(eA.size) { -1 }
////    val cacheB = IntArray(eB.size) { -1 }
////
////    val m1 = eA[0] + maxEnergy(true, 1, eA, eB, cacheA, cacheB)
////    val m2 = eB[0] + maxEnergy(false, 1, eA, eB, cacheA, cacheB)
////    return Math.max(m1, m2)
////}
////
////fun maxEnergy(selection: Int, hour: Int, eA: IntArray, eB: IntArray): Int {
////    if (hour == eA.size) return 0
////    var m1 = 0
////    var m2 = 0
////    var res = 0
////    if (selection) {
////        if (cacheA[i] != -1) return cacheA[i]
////        m1 = eA[i] + maxEnergy(true, i + 1, eA, eB)
////        m2 = eA[i] + maxEnergy(false, i + 2, eA, eB)
////        res = Math.max(m1, m2)
////        cacheA[i] = res
////
////    } else {
////        if (cacheB[i] != -1) return cacheB[i]
////        m1 = eB[i] + maxEnergy(false, i + 1, eA, eB)
////        m2 = eB[i] + maxEnergy(true, i + 2, eA, eB)
////        res = Math.max(m1, m2)
////        cacheB[i] = res
////    }
////
////    return res
////}
//
//fun main() {
//    val input1 = "[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]"
//    val input2 = "[0,1],[1,2],[2,3],[3,4],[0,5],[1,6],[2,7],[3,8]"
//    val input3 = "[0,1],[1,2],[1,3],[1,4],[0,5],[5,6],[6,7],[7,8],[0,9],[9,10],[9,12],[10,11]"
//    val input = "[6,0],[1,0],[5,1],[2,5],[3,1],[4,3]"
////    println("result = ${Test().countGoodNodes(convert(input1))}")
////    println("result = ${Test().countGoodNodes(convert(input2))}")
////    println("result = ${Test().countGoodNodes(convert(input3))}")
////        println("result = ${Test().countGoodNodes(convert(input))}")
//}


fun largestPalindrome(n: Int, k: Int): String {
    val arr = if (k == 8 || k == 6 || k == 4 || k == 2) {
        IntArray(n) { 8 }
    } else if (k == 5) {
        IntArray(n) { 5 }
    } else {
        IntArray(n) { 9 }
    }

    for (i in 1..<n - 1) {
        arr[i] = 9
    }


    while (true) {
        if (pal(arr) && isDivis(arr, k)) {
            val sb = StringBuilder()
            arr.forEach { sb.append(it) }
            return sb.toString()
        } else {
            sub1(arr)
        }
    }
    return ""
}

fun isDivis(a: IntArray, k: Int): Boolean {
    var num = 0L
    a.forEach { num = num * 10 + it }

    return (num % k == 0L)
}

fun pal(arr: IntArray): Boolean {
    var i = 0
    var j = arr.size - 1
    while (i < j) {
        if (arr[i] != arr[j]) return false
        i++
        j--
    }
    return true
}

fun sub1(ar: IntArray) {
    var c = ar.size - 1
    var carry = 0
    while (c > 0) {
        ar[c] -= carry
        if (ar[c] == 0) {
            ar[c] = 9
            carry = -1
        } else {
            ar[c]--
            break
        }
        c--
    }
}

fun main() {
    println(largestPalindrome(9, 5))
}