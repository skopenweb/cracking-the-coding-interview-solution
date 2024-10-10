//package misc
//
//class P3303 {
//    fun minStartingIndex(s: String, pattern: String): Int {
//        val result = intArrayOf(-1)
//        match(s, pattern, 0, 0, result, true)
//        return result[0]
//    }
//
//    fun match(s: String, p: String, si: Int, pi: Int, result: IntArray, allowed: Boolean) {
//        if (result[0] > -1) return
//        if (pi == p.length) {
//            result[0] = si - p.length
//            return
//        }
//        if(si >= s.length) return
//        if (s[si] == p[pi]) {
//            match(s, p, si+1, pi+1, result, allowed)
//        } else {
//            if (allowed) {
//                match(s, p, si+1, pi+1, result, false)
//            } else {
//                return
//            }
//            if (pi == 0) match(s, p, si+1, pi, result, allowed)
//        }
//    }
//}
//
//fun main() {
//    val index = P3303().minStartingIndex("ababbababa", "bacaba")
//    println("index = $index")
//}