import org.example.Stack
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class StackTest {

    @Test
    fun push() {
        val s = Stack<String>()
        s.push("hello")
        s.push("world")
        assertEquals(s.peek(), "world")
        s.pop()
        assertEquals(s.peek(), "hello")

    }

    @Test
    fun pop() {

    }

    @Test
    fun peek() {
    }

    @Test
    fun isEmpty() {
        val s = Stack<String>()
        assertTrue(s.isEmpty())
        s.push("Hello")
        assertFalse(s.isEmpty())
        s.pop()
        assertTrue(s.isEmpty())
    }
}