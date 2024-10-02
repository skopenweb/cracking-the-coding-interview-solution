package sortingSearching

import prettyPrint

class Node<T>(val data: T, var next: Node<T>? = null)

fun <T : Comparable<T>> myQuicksort(a: Array<T>) {
    quicksort(a, 0, a.size - 1)
}

fun <T : Comparable<T>> quicksort(a: Array<T>, l: Int, r: Int) {
    if (l < r) {
        val p = partition(a, l, r)
        quicksort(a, l, p - 1)
        quicksort(a, p + 1, r)
    }
}

fun <T : Comparable<T>> partition(a: Array<T>, l: Int, r: Int): Int {
    var firstHigh = l
    val pivot = a[r]
    while (firstHigh < r && a[firstHigh] <= pivot) {
        firstHigh++
    }
    var i = firstHigh + 1
    while (i < r) {
        if (a[i] < pivot) {
            a.swap(i, firstHigh)
            firstHigh++
        }
        i++
    }
    a.swap(firstHigh, r)
    a.prettyPrint()
    println()
    return firstHigh
}

fun <T> Array<T>.swap(i: Int, j: Int) {
    val t = this[i]
    this[i] = this[j]
    this[j] = t
}

fun <T : Comparable<T>> bubbleSort(a: Array<T>) {
    for (i in a.size - 1 downTo 1) {
        for (j in 1..i) {
            if (a[j] < a[j - 1]) {
                a.swap(j, j - 1)
            }
        }
    }
}

fun <T : Comparable<T>> mergeSort(a: Array<T>, s: Int, e: Int) {
    if( s < e) {
        val mid = (s + e) / 2
        mergeSort(a, s, mid)
        mergeSort(a, mid + 1, e)
        merge(a, s, mid, e)
    }
}

fun <T : Comparable<T>> merge(a: Array<T>, l: Int, mid: Int, r: Int) {
    val temp = mutableListOf<T>()
    for (i in l..r) {
        temp.add(a[i])
    }
    var i1 = l
    var i2 = mid + 1
    var i = l
    while (i1 <= mid && i2 <= r) {
        if (i1 > mid || i2 > r) break
        if (a[i1] < a[i2]) {
            temp[i] = a[i1++]
        } else {
            temp[i] = a[i2++]
        }
        i++
    }
    while (i1 <= mid) {
        temp[i++] = a[i1++]
    }
    for (j in l..r) {
        a[j] = temp[j]
    }
}