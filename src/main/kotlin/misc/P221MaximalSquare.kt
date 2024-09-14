//package misc
//
//class P221MaximalSquare {
//    fun maximalSquare(matrix: Array<CharArray>): Int {
//        val m = matrix.size
//        val n = matrix[0].size
//        val s = m.coerceAtMost(n)
//        for (i in s downTo 1) {
//            var zeroFound = false
//            for (j1 in 0..m - i) {
//                for (j2 in 0..n - i) {
//                    for (k1 in 0..<i) {
//                        for (k2 in 0..<i) {
//                            if (matrix[j1 + k1][j2 + k2] == '0') {
//                                zeroFound = true
//                                break
//                            }
//                        }
//                    }
//                    if (zeroFound.not()) {
//                        return i
//                    }
//                }
//            }
//        }
//        return 0
//    }
//
//    fun main() {
//        val a1 = arrayOf(
//            charArrayOf('0', '1'),
//            charArrayOf('1', '0'),
//        )
//
//        println("maximal square = ${P221MaximalSquare().maximalSquare(a1)}")
//    }
