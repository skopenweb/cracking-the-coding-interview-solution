package linkedList

import linkedLists.*
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LinkedListTest {

    @Test
    fun `remove duplicates`() {
        val original = createList(1, 2, 3, 4, 3, 2, 1)
        val expected = createList(*((1..4).toList().toIntArray()))

        linked_list_2_1_remove_dups(original)

        assert(original == expected) { "duplicate shall be removed" }
    }

    @Test
    fun `kth element shall be returned`() {
        val numbers = intArrayOf(1, 2, 3, 3, 4, 2, 1)
        val list = createList(*numbers)

        val kthNode = linked_list_2_2_kth_to_last(list, 3)

        assert(kthNode?.value == 4) { "kth node" }
    }

    @Test
    fun `delete middle node`() {
        val numbers = intArrayOf(1, 2, 13, 14, 12)
        val list = createList(*numbers)
        val expected = createList(1, 2, 14, 12)

        linked_list_2_3_delete_middle_node(list)
        expected.print()
        list.print()

        assert(expected == list) { "delete middle node" }
    }

    @Test
    fun `linked-list partition`() {
        val numbers = intArrayOf(1, 2, 5, 10, 3, 20, 4, 5)
        val list = createList(*numbers)
        val expected = createList(4, 3, 1, 2, 5, 10, 20, 5)

        linked_list_2_4_partition(list, 5)
        expected.print()
        list.print()

        assert(expected == list) { "partition middle node" }
    }

    @Test
    fun `sum of two numbers`() {
        val l2 = createList(9, 9, 9)
        val l1 = createList(1)
        val expected = createList(0, 0, 0, 1)

        val sumList = linked_list_2_5_sum_list(l1, l2)

        arrayOf(l1, l2, sumList).forEach { it.print() }

        assert(sumList == expected)
    }

    @Test
    fun `palindrome number`() {
        val l1 = createList(1, 2, 3)
        val l2 = createList(1, 2, 3, 4, 3, 2, 1)
        val l3 = createList(1, 2, 3, 4, 4, 3, 2, 1)
        val l4 = createList(1, 2, 3, 4, 5, 3, 2, 1)

        assertFalse(linked_list_2_6_palindrome(l1))
        assertTrue(linked_list_2_6_palindrome(l2))
        assertTrue(linked_list_2_6_palindrome(l3))
        assertFalse(linked_list_2_6_palindrome(l4))
    }

    internal fun createList(vararg numbers: Int): LinkedList {
        val l = LinkedList()
        numbers.forEachIndexed { index, _ ->
            val curr = numbers[numbers.size - 1 - index]
            l.add(Node(curr))
        }
        return l
    }

}
