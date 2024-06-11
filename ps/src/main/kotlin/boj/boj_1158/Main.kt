package boj.boj_1158

import java.util.LinkedList

fun main() {
    val people = LinkedList<Int>()
    val removedPeople = LinkedList<Int>()

    val (n, k) = readln().split(" ")
        .map { it.toInt() }

    for (idx in 1..n) {
        people.addLast(idx)
    }

    var index = 0
    while (people.isNotEmpty()) {
        val next = (index + k - 1) % people.size
        val removedIdx = people.removeAt(next)
        removedPeople.addLast(removedIdx)
        index = next
    }
    val answer = removedPeople.joinToString(
        prefix = "<",
        separator = ", ",
        postfix = ">"
    )
    println(answer)
}
