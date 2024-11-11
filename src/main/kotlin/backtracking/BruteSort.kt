package backtracking

import prettyPrint

class BruteSort {

    fun bruteSort(arr: IntArray) {
        bruteSort(arr, 0)
    }

    fun bruteSort(a: IntArray, index: Int): Boolean {
        a.prettyPrint()
        if (index > 0) {
            if (a[index] < a[index -1]) return false
            if (index == a.size - 1) {
                return checkIfSorted(a)
            }
        }
        for (i in index..<a.size) {
            swap(a, index, i)
            val result = bruteSort(a, index + 1)
            if (result) return true
            swap(a, index, i)
        }
        return false
    }

    fun swap(a: IntArray, i: Int, j: Int) {
        val temp = a[i]
        a[i] = a[j]
        a[j] = temp
    }

    private fun checkIfSorted(a: IntArray): Boolean {
        var j = 1
        while (j < a.size && a[j] >= a[j - 1]) j++
        return j == a.size
    }
}

fun main() {
    val a = intArrayOf(5, 1, 4, 2)
    BruteSort().bruteSort(a)

    a.prettyPrint()
}
