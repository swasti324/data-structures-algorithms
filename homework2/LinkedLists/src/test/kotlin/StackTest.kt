import org.example.Stack
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class StackTest {

    @Test
    fun push() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)

        assertEquals(2, stack.peek())
    }

    @Test
    fun pop() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        assertEquals(2, stack.pop())
        assertEquals(1, stack.pop())
    }

    @Test
    fun peek() {
    }

    @Test
    fun isEmpty() {
        val stack = Stack<Int>()
        assertTrue(stack.isEmpty())

        stack.push(1)
        assertFalse(stack.isEmpty())

    }
}