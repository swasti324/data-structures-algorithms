package org.example

class Queue<T> {
    private val myLinkedList = MyDoublyLinkedList<T>()

    fun enqueue(item: T) {
        myLinkedList.pushBack(item)
    }

    fun dequeue(): T? {
        return myLinkedList.popFront()
    }

    fun peek(): T? {
        return myLinkedList.peekFront()
    }

    fun isEmpty(): Boolean {
        return myLinkedList.isEmpty()
    }
}
