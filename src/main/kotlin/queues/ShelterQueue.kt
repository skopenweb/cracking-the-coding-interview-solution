package queues

class ShelterQueue {
    inner class Node(var data: String, var prev: Node? = null, var next: Node? = null)

    private var head: Node? = null
    private var tail: Node? = null
    fun enqueue(animal: String) {
        if (head == null) {
            val n = Node(data = animal)
            head = n
            tail = n
        } else {
            val n = Node(data = animal)
            tail?.next = n
            n.prev = tail
            tail = n
        }
    }

    fun dequeueCat(): Node? {
        if (head == null) return null
        var curr = head

        while (curr != null) {
            if (curr.data == "cat") break
            curr = curr.next
        }
        if (curr == null) return null
        dequeueNode(curr)
        return curr
    }

    fun dequeueNode(n: Node) {
        if (n == head && n == tail) {
            head = null
            tail = null
        } else if (n == head) {
            head = head?.next
            head?.prev = null
        } else if (n == tail) {
            tail = tail?.prev
            tail?.next = null
        } else {
            n.prev?.next = n.next
            n.next?.prev = n.prev
        }
    }

    fun dequeueDog(dog: String): Node? {
        if (head == null) return null
        var curr = head

        while (curr != null) {
            if (curr.data == "cat") break
            curr = curr.next
        }
        if (curr == null) return null
        dequeueNode(curr)
        return curr
    }

    fun dequeue(): Node? {
        if (head == null) return null
        val node = head
        if (head == tail) {
            head = null
            tail = null
        } else {
            head = head?.next
            head?.prev = null
        }
        return node
    }
}