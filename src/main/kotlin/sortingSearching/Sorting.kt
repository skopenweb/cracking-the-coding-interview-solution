package sortingSearching


class Node<T>(val data: T, var next: Node<T>? = null)


fun <T : Comparable<T>> quicksort(a: Array<T>) {
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
    return firstHigh
}

fun <T> Array<T>.swap(i: Int, j: Int) {
    val t = this[i]
    this[i] = this[j]
    this[j] = t
}

