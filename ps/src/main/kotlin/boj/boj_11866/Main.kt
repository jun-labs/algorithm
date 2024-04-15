package boj.boj_11866

import java.util.LinkedList

fun main() {
    val people = LinkedList<Person>()
    val removed = LinkedList<Person>()
    val (n, k) = readln().split(" ")
        .map { it.toInt() }

    for (idx in 1..n) {
        people.addLast(Person(idx))
    }

    var index = 0
    while (people.isNotEmpty()) {
        index = (index + k - 1) % people.size
        removed.add(people.removeAt(index))
    }
    val answer = removed.joinToString(
        prefix = "<",
        postfix = ">",
        separator = ", "
    ) { it.id.toString() }
    println(answer)
}

data class Person(
    val id: Int,
)
