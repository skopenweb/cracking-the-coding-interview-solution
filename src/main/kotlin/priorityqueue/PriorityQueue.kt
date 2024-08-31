package priorityqueue

interface PriorityQueue<T> {
    fun size(): Int
    fun isEmpty(): Boolean
    fun insert(x: T)
    fun deleteMin(): T
    fun min(): T
}

class BinaryHeap<T : Comparable<T>> : PriorityQueue<T> {
    private val items: Array<Any>
    private var currSize: Int = 0

    constructor(maxSize: Int) {
        items = Array(maxSize) {}
    }

    constructor (items: Array<T>) {
        this.items = items.map { it }.toTypedArray()
        for (i in items.indices) {
            heapifyDown(items.size - 1 - i)
        }
    }

    override fun insert(x: T) {
        if (currSize == items.size) throw IllegalStateException("heap is full")
        items[currSize] = x
        heapifyUp(currSize)
        currSize++
    }

    override fun size() = currSize
    override fun isEmpty() = size() == 0
    override fun deleteMin(): T {
        if (currSize == 0) throw IllegalStateException("empty heap")
        val min = items[0]
        items[0] = items[currSize - 1]
        currSize--

        heapifyDown(0)
        return min as T
    }

    override fun min() = items[0] as T
    private fun parent(i: Int) = (i - 1) / 2
    private fun left(index: Int) = 2 * index + 1
    private fun right(index: Int) = 2 * index + 2
    private fun heapifyUp(i: Int) {
        var curr = i
        while (curr > 0) {
            val p = parent(i)
            if (items[p] as T > items[curr] as T) {
                swap(items, i, p)
                curr = p
            } else break
        }
    }

    private fun heapifyDown(i: Int) {
        var shallHeapify = true
        var curr = i
        do {
            val l = left(i)
            val r = right(i)

            var min = curr
            if (l < currSize && (items[l] as T) < (items[curr] as T)) {
                min = l
            }
            if (r < currSize && items[min] as T > items[r] as T) {
                min = r
            }
            if (min == curr) {
                shallHeapify = false
            } else {
                swap(items, min, curr)
                curr = min
            }
        } while (shallHeapify)
    }

    private fun swap(a: Array<Any>, i: Int, j: Int) {
        val t = a[i]
        a[i] = a[j]
        a[j] = t
    }
}

fun main() {
    val testArray = IntArray(5)
    testArray.forEach { print("$it") }

    println("Hello ${-112 / 3}")
}