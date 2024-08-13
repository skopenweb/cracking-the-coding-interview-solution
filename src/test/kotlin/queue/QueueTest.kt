package queue

import queues.QueueImpl
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class QueueTest {

    @Test
    fun `empty queue`() {
        val q = QueueImpl<Int>()
        q.enqueue(12)
        q.dequeue()

        assertTrue(q.isEmpty(), "queue shall be empty")
    }

    @Test
    fun `empty queue again`() {
        val q = QueueImpl<Int>()
        q.enqueue(12)
        q.dequeue()
        q.enqueue(13)
        q.dequeue()
        q.enqueue(13)
        q.dequeue()

        assertTrue(q.isEmpty(), "queue shall be empty")
    }

    @Test
    fun `peek of queue works fine`() {
        val q = QueueImpl<Int>()
        q.enqueue(12)
        q.enqueue(13)
        q.enqueue(99)
        q.dequeue()

        assertEquals(q.peek(), 13, "queue shall be empty")
    }

    @Test
    fun `dequeue works fine`() {
        val q = QueueImpl<Int>()
        q.enqueue(12)
        q.enqueue(13)
        q.dequeue()
        q.enqueue(99)
        q.enqueue(100)
        q.dequeue()

        assertFalse(q.isEmpty(), "queue shall not be empty")
        assertEquals(99, q.dequeue(), "queue dequeue shall be first element")
    }
}