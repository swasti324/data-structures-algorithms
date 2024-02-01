package org.example

/**
 * An implementation of a LIFO (last in, first out) structure called Stack
 * @param T data stored in the stack
 * @property top reference the top element in the stack
 */
class Stack<T> {
    var top: StackNode<T>? = null

    fun push(data:T){
        /**
         * Push [data] onto the Stack
         * @param data the new value to put onto the stack
         */
        val node = StackNode(data, top)
        top = node
    }

    fun pop(): T? {
        /**
         * Pop the top element off the satack
         * @return the top element if it's not empty, else return null
         */
        val temp = peek()
        top = top?.next
        return temp
    }

    fun peek(): T? {
        /**
         * @return the top element if it's not empty, else return null
         * Unlike pop() this does not change the elements.
         */
        return top?.data
    }

    fun isEmpty(): Boolean{
        /**
         * this checks if the stack is empty
         */
        return top == null
    }

}

/**
 * @property data the string data associated with the node
 *  @property next represents the new node
 */
class StackNode<T>(val data:T, var next:StackNode<T>?)