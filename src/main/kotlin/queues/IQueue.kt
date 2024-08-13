package queues

class Node<T>(var data: T, var next: Node<T>? = null)

interface IQueue<T> {
    fun peek(): T
    fun enqueue(data: T)
    fun dequeue(): T
    fun isEmpty(): Boolean

    val size: Int
}

class QueueImpl<T> : IQueue<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private val lock = Object()

    override fun isEmpty() = head == null

    override val size: Int
        get() = synchronized(lock) {
            var size = 0
            var curr = head
            while (curr != null) {
                curr = curr.next
                size++
            }
            return size
        }
    override fun peek(): T {
        if (head == null) throw IllegalStateException("empty queue")
        synchronized(lock) {
            if (head == null) throw IllegalStateException("empty queue")
            else return head!!.data
        }
    }

    override fun dequeue(): T {
        if (isEmpty()) throw IllegalStateException("empty queue")
        synchronized(lock) {
            val node = head
            if (head == tail) {
                head = null
                tail = null
            } else {
                head = head?.next
            }
            return node!!.data
        }
    }

    override fun enqueue(data: T) {
        val newNode = Node(data = data)
        synchronized(lock) {
            if (isEmpty()) {
                head = newNode
                tail = newNode
            } else {
                tail?.next = newNode
                tail = newNode
            }
        }
    }
}


fun main() {
    val q = QueueImpl<Int>()

    for (i in 1..5) {
        q.enqueue(i)
    }
    q.dequeue()
    q.enqueue(12)
}