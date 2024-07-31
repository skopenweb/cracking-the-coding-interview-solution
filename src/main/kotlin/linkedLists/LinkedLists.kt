package linkedLists

class Node(var value: Int = -1, var next: Node? = null)

class LinkedList(var head: Node? = null) {

    fun isEmpty() = head == null

    val size: Int
        get() = run {
            var count = 0
            var curr = head
            while (curr != null) {
                curr = curr.next
                count++
            }
            return count
        }

    fun add(n: Node): LinkedList {
        n.next = head
        head = n
        return this
    }

    fun remove(v: Int): Node? {
        var curr = head
        if (curr?.value == v) {
            head = head?.next
            return curr
        }
        while (curr?.next != null) {
            if (curr.next?.value == v) {
                val deleted = curr.next
                curr.next = curr.next?.next
                return deleted
            }
            curr = curr.next
        }
        return null
    }
}

fun LinkedList.print() {
    var curr = head
    while (curr != null) {
        print("${curr.value}->")
        curr = curr.next
    }
    println(null)
}

fun linked_lists_2_1_remove_dups(l: LinkedList) {
    if (l.isEmpty()) {
        return
    }
    var curr = l.head
    while (curr != null) {
        val temp = curr
        val currVal = curr.value
        while (curr?.next != null) {
            if (curr.next?.value == currVal) {
                curr.next = curr.next?.next
            } else {
                curr = curr.next
            }
        }
        curr = temp.next
    }
}

fun linked_lists_2_2_kth_to_last(l: LinkedList, k: Int): Node? {
    if (l.isEmpty()) return null

    var curr = l.head
    var next = curr
    repeat(k - 1) {
        if (next == null) return null
        next = next?.next
    }
    while (next?.next != null) {
        curr = curr?.next
        next = next?.next
    }
    return curr
}

fun linked_lists_2_2_kth_to_last_recursive(l: LinkedList, k: Int): Node? {
    // TODO
    return null
}


fun main() {
    println("Cracking the coding interview")
    println("Chapter 2: Linked Lists")

    val l1 = LinkedList()
    l1.print()

    l1.add(Node(11)).add(Node(13)).add(Node(11)).add(Node(12)).add(Node(12)).add(Node(12)).add(Node(12)).add(Node(13))
    l1.print()

    linked_lists_2_1_remove_dups(l1)
    l1.print()
}