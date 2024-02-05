import org.example.MyDoublyLinkedList
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class DoublyLinkedListTest {

    @Test
    fun isEmpty() {
        val test = MyDoublyLinkedList<String>()
        assertTrue(test.isEmpty())
        test.pushBack("world")
        assertFalse(test.isEmpty())
    }

    @Test
    fun pushFront() {
        val test = MyDoublyLinkedList<String>()
        test.pushFront("world")
        test.pushFront("hello")
        assertEquals(test.peekFront(), "hello")
        assertEquals(test.peekBack(), "world")
    }

    @Test
    fun pushBack() {
        val test = MyDoublyLinkedList<String>()
        test.pushBack("hello")
        test.pushBack("world")
        assertEquals(test.peekFront(), "hello")
        assertEquals(test.peekBack(), "world")
    }

    @Test
    fun popFront() {
        val test = MyDoublyLinkedList<String>()
        test.pushFront("world")
        test.pushFront("hello")
        test.popFront()
        assertEquals(test.peekFront(), "world")
        assertEquals(test.peekBack(), "world")
    }

    @Test
    fun popBack() {
        val test = MyDoublyLinkedList<String>()
        test.pushBack("hello")
        test.pushBack("world")
        test.popBack()
        assertEquals(test.peekFront(), "hello")
        assertEquals(test.peekBack(), "hello")
    }

    @Test
    fun peekFront() {
        val test = MyDoublyLinkedList<Int>()
        test.pushFront(909)
        assertEquals(test.peekFront(),909)
    }

    @Test
    fun peekBack() {
        val test = MyDoublyLinkedList<Int>()
        test.pushBack(909)
        assertEquals(test.peekBack(),909)
    }
}