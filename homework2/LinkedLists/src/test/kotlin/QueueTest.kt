import org.example.Queue
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class QueueTest {

    @Test
    fun enqueue() {
        val queue = Queue<String>()

        queue.enqueue("hello")
        queue.enqueue("world")

        assertEquals(queue.peek(),"hello")
    }

    @Test
    fun dequeue() {
        val queue = Queue<String>()
        queue.enqueue("hello")
        queue.enqueue("world")

        assertEquals("hello", queue.dequeue())
    }

    @Test
    fun peek() {
        val queue = Queue<String>()

        queue.enqueue("hello")
        queue.enqueue("world")

        assertEquals(queue.peek(),"hello")
    }

    @Test
    fun isEmpty() {
        val queue = Queue<String>()
        assertTrue(queue.isEmpty())
        queue.enqueue("world")
        assertFalse(queue.isEmpty())
    }
}