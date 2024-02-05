package org.example


interface DoublyLinkedList<T> {
    fun isEmpty():Boolean
    fun pushFront(data:T)
    fun pushBack(data:T)
    fun popFront():T?
    fun popBack():T?
    fun peekFront():T?
    fun peekBack():T?
}

class MyDoublyLinkedList<T>:DoublyLinkedList<T>{
    var head: LLNode<T>? = null
    var tail: LLNode<T>? = null
    var size:Int = 0

    override fun isEmpty():Boolean{
        return size == 0
    }
    override fun pushFront(data:T){
        val newNode = LLNode(data)
        if(isEmpty()){
            head = newNode
            tail = newNode
        }
        else{
            newNode.next = head
            head = newNode
        }
        size++
    }
    override fun pushBack(data:T){
        val newNode = LLNode(data)
        if(isEmpty()){
            head = newNode
            tail = newNode
        }
        else{
            newNode.prev = tail
            tail = newNode
        }
        size++
    }
    override fun popFront():T?{
        val temp = head?.data
        head = head?.next
        if (head == null){
            tail = null
        }
        else{
            head?.prev = null
        }
        size --
        return temp
    }
    override fun popBack():T?{
        val temp = tail?.data
        tail = tail?.prev
        if (tail == null){
            head = null
        }
        else{
            tail?.next = null
        }
        size --
        return temp
    }
    override fun peekFront():T?{
        return head?.data
    }
    override fun peekBack():T?{
        return tail?.data
    }

}
class LLNode<T>(val data:T){
    var next:LLNode<T>? = null
    var prev:LLNode<T>? = null
}