//package dp
//
//class P85MaximalRectangle {
//
//    data class Data(val x: Int, val y: Int)
//
//    fun maximalRectangle(matrix: Array<CharArray>): Int {
//        val m = matrix.size
//        val n = matrix[0].size
//        val countRow = Array(m) { IntArray(n) }
//        val countCol = Array(m) { IntArray(n) }
//
//        for (i in 0..<m) {
//            var r = n - 1
//            var count = 0
//            while (r >= 0) {
//                if (matrix[i][r] == '1') count++
//                else count = 0
//                countRow[i][r] = count
//                r--
//            }
//        }
//
//        for (j in 0..<n) {
//            var d = m - 1
//            var count = 0
//            while (d >= 0) {
//                if (matrix[d][j] == '1') count++
//                else count = 0
//                countCol[d][j] = count
//                d--
//            }
//        }
//        val res = Array(m) { Array<Data>(n) { Data(0, 0) } }
//        solve(res, countRow, countCol)
//        return res[0][0].x * res[0][0].y
//    }
//
//    fun solve(res: Array<Array<Data>>, countRow: Array<IntArray>, countCol: Array<IntArray>) {
//        val m = countRow.size
//        val n = countRow[0].size
//
//        for (i in m - 1 downTo 0) {
//            for (j in n - 1 downTo 0) {
//                if (i == m - 1) {
//                    if (countRow[i][j] == 0) {
//                        res[i][j] = Data(0, 0)
//                    } else {
//                        res[i][j] = Data(countRow[i][j], 1)
//                    }
//                } else if (j == n - 1) {
//                    if (countCol[i][j] == 0) {
//                        res[i][j] = Data(0, 0)
//                    } else {
//                        res[i][j] = Data(countCol[i][j], 1)
//                    }
//                } else {
//                    val currX = countRow[i][j]
//                    val currY = countCol[i][j]
//
//                    var m = Math.max(currX, currY)
//
//                    if (countRow[i][j] > res[i][j+1].x && countCol[i][j] > res[i+1][j].y) {
//                        val m11 = m1coerceAtLeast()
//                    }
//                    res[i][j] = Data(x = Math.min(countCol[i+1][])
//                }
//            }
//        }
//    }
//
//}