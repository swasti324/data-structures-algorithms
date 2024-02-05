package org.example
import java.util.*

class Stack<T> {
    private val myLinkedList = MyDoublyLinkedList<T>()

    fun push(item: T) {
        myLinkedList.pushFront(item)
    }

    fun pop(): T? {
        return myLinkedList.popFront()
    }

    fun peek(): T? {
        return myLinkedList.peekFront()
    }
    fun reverse(){
        val tempStack = Stack<T>()

        while (!myLinkedList.isEmpty()) {
            tempStack.push(myLinkedList.popFront()!!)
        }

        while (!tempStack.isEmpty()) {
            myLinkedList.pushFront(tempStack.pop()!!)
        }
    }
    fun isEmpty(): Boolean {
        return myLinkedList.isEmpty()
    }
}