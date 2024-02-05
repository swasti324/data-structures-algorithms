package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val stackReverser = Stack<Int>()

    stackReverser.push(1)
    stackReverser.push(2)
    stackReverser.push(3)

    println("Original Stack:")
    while (!stackReverser.isEmpty()) {
        print("${stackReverser.pop()} ")
    }

    stackReverser.push(1)
    stackReverser.push(2)
    stackReverser.push(3)

    stackReverser.reverse()

    println("\nReversed Stack:")
    while (!stackReverser.isEmpty()) {
        print("${stackReverser.pop()} ")
    }
}