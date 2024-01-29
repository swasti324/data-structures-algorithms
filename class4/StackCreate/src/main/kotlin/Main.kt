package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val s= Stack<String>()
    s.push("Hello")
    println(s.isEmpty())
    println(s.pop())
    println(s.peek())
    println(s.pop())
    println(s.isEmpty())

}