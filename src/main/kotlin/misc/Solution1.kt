package misc;

import kotlin.random.Random

class Solution1 {
    fun findMinDifference(timePoints: List<String>): Int {
        val arr = Array<Int>(timePoints.size) { 0 }

        timePoints.forEachIndexed { index, item ->
            arr[index] = item.toMinutes()
        }
        quickSort(arr, 0, arr.size - 1)

        var min = Int.MAX_VALUE
        for (i in 1..<arr.size) {
            val diff = arr[i] - arr[i - 1]
            if (diff < min) {
                min = diff
            }
        }

        return min
    }

    fun quickSort(a: Array<Int>, l: Int, r: Int) {
        if (l > r) return
        val p = partition(a, l, r)

        quickSort(a, l, p - 1)
        quickSort(a, p + 1, r)
    }

    fun partition(a: Array<Int>, l: Int, r: Int): Int {
        val p = a[r]

        var firstHigh = l
        while (firstHigh < r && a[firstHigh] <= p) {
            firstHigh++
        }
        var curr = firstHigh
        while (curr < r) {
            if (a[curr] < p) {
                swap(a, firstHigh, curr)
                firstHigh++
            }
            curr++
        }
        swap(a, firstHigh, r)
        return firstHigh
    }

    fun swap(a: Array<Int>, l: Int, h: Int) {
        val t = a[l]
        a[l] = a[h]
        a[h] = t
    }

    fun String.toMinutes(): Int {
        var m = 0
        var curr = 0
        forEach { item ->
            if (item == ':') {
                m = curr * 60
            } else {
                curr = curr * 10 + (item - '0')
            }
        }
        return m + curr
    }
}


class Solution(w: IntArray) {
    val ww = w
    var sum = IntArray(w.size) {w[it]}
    init {
        for (i in 1..<w.size) {
            w[i]+= w[i-1]
        }
    }
    val rnd = Random(System.currentTimeMillis())

    fun pickIndex(): Int {
        val elem = rnd.nextInt(sum[0], sum[sum.size-1])
        return ww[search(sum, elem)]
    }

    fun search(a: IntArray, e: Int): Int {
        var l = 0
        var r = a.size - 1
        var mid = l
        while(l<r) {
            val mid = (l + r)/2

            if (a[mid] >= e) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        return mid
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(w)
 * var param_1 = obj.pickIndex()
 */
fun main() {
    val ans = Solution1().findMinDifference(listOf("00:59", "23:59", "00:50"))
    println(ans)
}