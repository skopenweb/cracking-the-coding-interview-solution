package priorityqueue

fun kth_largeset_element(array: Array<Int>): Int {
    val priorityQueue = BinaryHeap(array)
    print("[")
    for (i in array) {
        println("${priorityQueue.deleteMin()}, ")
    }
    println("]")
    return 0
}

fun main() {
    val a = arrayOf(12, 13, 4, 1, 8, 19, 22)
    kth_largeset_element(a)
}