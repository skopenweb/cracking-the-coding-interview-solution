package linkedLists

internal class Node(var value: Int = -1, var next: Node? = null) {
    override fun toString(): String {
        return String.format("{$value, ${next.hashCode()} ")
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Node) return false
        return (value == other.value && next.hashCode() == other.next.hashCode())
    }
}

internal class LinkedList(var head: Node? = null) : IList {
    override fun isEmpty() = head == null

    override val size: Int
        get() = run {
            var count = 0
            var curr = head
            while (curr != null) {
                curr = curr.next
                count++
            }
            return count
        }

    override fun add(n: Node): LinkedList {
        n.next = head
        head = n
        return this
    }

    override fun remove(v: Int): Node? {
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

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is LinkedList) return false
        var h1 = this.head
        var h2 = other.head
        do {
            if (h1?.value != h2?.value) return false
            h1 = h1?.next
            h2 = h2?.next
        } while (h1 != null && h2 != null)
        return true
    }
}

internal fun LinkedList.print() {
    var curr = head
    while (curr != null) {
        print("${curr.value}->")
        curr = curr.next
    }
    println(null)
}

internal fun linked_list_2_1_remove_dups(l: LinkedList) {
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

internal fun linked_list_2_2_kth_to_last(l: LinkedList, k: Int): Node? {
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

internal fun linked_list_2_2_kth_to_last_2(l: LinkedList, k: Int): Node? {
    var kthNode = l.head
    var end = kthNode

    var i = 0
    while (end != null && i < k) {
        end = end.next
        i++
    }
    if (i < k) return null
    while (end != null) {
        end = end.next
        kthNode = kthNode?.next
    }
    return kthNode
}

internal fun linked_list_2_2_kth_to_last_recursive(l: LinkedList, k: Int): Node? {
    if (l.isEmpty()) return null

    val kthPair = findElem(l.head, k)
    return kthPair.second
}

internal fun findElem(node: Node?, k: Int): Pair<Int, Node?> {
    if (node == null) return Pair(0, null)
    val res = findElem(node.next, k)
    return if (res.first == k - 1) {
        Pair(k, node)
    } else {
        Pair(first = res.first + 1, second = null)
    }
}

internal fun linked_list_2_3_delete_middle_node(l: LinkedList) {
    if (l.isEmpty()) return
    deleteMid(l.head, 1)
}

internal fun deleteMid(n: Node?, count: Int): Int {
    if (n == null) return count
    val size = deleteMid(n.next, count + 1)
    if (size > 2 && count == (size - 1) / 2) {
        n.next = n.next?.next
    }
    return size
}

internal fun linked_list_2_4_partition(l: LinkedList, x: Int) {
    if (l.isEmpty()) return
    var curr = l.head
    while (curr != null && curr.value < x) {
        curr = curr.next
    }
    if (curr == null) return                    // partition is done already
    do {
        val next = curr?.next ?: return
        if (next.value < x) {
            curr.next = next.next
            l.add(next)
        } else {
            curr = next
        }
    } while (true)
}

internal fun linked_list_2_5_sum_list(l1: LinkedList, l2: LinkedList): LinkedList {
    if (l1.isEmpty()) return l2
    if (l2.isEmpty()) return l1

    var node1 = l1.head
    var node2 = l2.head

    var carry = 0

    var next1 = node1
    var next2 = node2

    while (next1 != null || next2 != null) {
        node1 = next1
        node2 = next2
        val sum = carry + (node1?.value ?: 0) + (node2?.value ?: 0)

        carry = sum / 10
        node1?.value = sum % 10

        if (next1 == null) {
            node1?.next = next2
            next1 = next2
            next2 = null
        } else {
            next1 = node1?.next
            next2 = node2?.next
        }
    }
    if (carry > 0) {
        node1?.next = Node(carry)
    }
    return l1
}

internal fun linked_list_2_6_palindrome(l: LinkedList): Boolean {
    if (l.isEmpty()) return false
    var revNode: Node? = null
    var currNode = l.head
    var count = 0
    while (currNode != null) {
        count++
        revNode = Node(currNode.value, revNode)
        currNode = currNode.next
    }

    currNode = l.head
    var i = 0
    while (i < count / 2) {
        if (currNode?.value != revNode?.value) {
            break
        }
        currNode = currNode?.next
        revNode = revNode?.next
        i++
    }
    return i == count / 2
}

internal fun linked_list_2_7_intersection(l1: LinkedList, l2: LinkedList): Node? {
    val s1 = mutableSetOf<Node>()
    val s2 = mutableSetOf<Node>()

    var c1 = l1.head
    var c2 = l2.head
    while (c1 != null && c2 != null) {
        s1.add(c1)
        s2.add(c2)

        if (s1.contains(c2)) return c2
        if (s2.contains(c1)) return c1

        c1 = c1.next
        c2 = c2.next
    }
    return null
}

internal fun linked_list_2_8_loop(l: LinkedList): Node? {
    if (l.isEmpty()) return null
    var slow = l.head
    var fast = l.head
    while (slow != null && fast != null) {
        slow = slow.next
        fast = fast.next?.next

        if (slow == fast) break
    }
    slow = l.head
    while (slow != fast) {
        slow = slow?.next
        fast = fast?.next
    }

    return slow
}

fun main() {
    println("Cracking the coding interview")
    println("Chapter 2: Linked Lists")

    val l1 = LinkedList()
    l1.print()

    l1.add(Node(11)).add(Node(13)).add(Node(11)).add(Node(12)).add(Node(12)).add(Node(12)).add(Node(12)).add(Node(13))
    l1.print()

    linked_list_2_1_remove_dups(l1)
    l1.print()
}