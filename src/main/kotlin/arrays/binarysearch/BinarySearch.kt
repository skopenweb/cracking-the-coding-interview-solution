package arrays.binarysearch

/**
 * Search an element in array 'a'
 */
fun <T : Comparable<T>> search(a: Array<T>, target: T): Int {
    if (a.isEmpty()) return -1
    var left = 0
    var right = a.size - 1
    if (a[left] > target || a[right] < target) return -1

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (a[mid] == target) {
            return mid
        } else if (a[mid] > target) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return -1
}

fun <T : Comparable<T>> searchStrictlyGreater(a: Array<T>, target: T): Int {
    if (a.isEmpty()) return -1
    var l = 0
    var r = a.size - 1

    if (a[r] <= target) return -1

    while (l < r) {
        val mid = (l + r) / 2
        if (a[mid] <= target) {
            l = mid + 1
        } else {    // a[mid] > target
            r = mid
        }
    }
    return l
}

fun <T : Comparable<T>> searchStrictlyLess(a: Array<T>, target: T): Int {
    if (a.isEmpty()) return -1
    var l = 0
    var r = a.size - 1

    if (a[l] >= target) return -1

    while (l < r) {
        val mid = (l + r + 1) / 2
        if (a[mid] >= target) {
            r = mid - 1
        } else { // a[mid] < target
            l = mid
        }
    }
    return l
}


fun main() {
    val a1 = arrayOf(1, 2, 4, 5)
    val a2 = arrayOf(20, 24, 27, 99)

    println(searchStrictlyGreater(a1, 1))     // 3
    println(searchStrictlyGreater(a1, 0))     // 3
//    println(searchStrictlyGreater(a1, 12))     // 1
}