package boj.boj_1916

import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val nodes = Array(n + 1) { mutableListOf<Node>() }
    val distance = IntArray(n + 1) { Int.MAX_VALUE }

    for (i in 0 until m) {
        val (start, end, cost) = readln().split(" ")
            .map { it.toInt() }
        nodes[start].add(Node(end, cost))
    }

    val (startCity, endCity) = readln().split(" ")
        .map { it.toInt() }

    dijkstra(startCity, nodes, distance)
    println(distance[endCity])
}

fun dijkstra(
    start: Int,
    nodes: Array<MutableList<Node>>,
    distance: IntArray,
) {
    val queue = PriorityQueue<Node>()
    queue.add(Node(start, 0))
    distance[start] = 0

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        if (node.cost > distance[node.idx]) continue

        for (nextNode in nodes[node.idx]) {
            if (distance[nextNode.idx] > distance[node.idx] + nextNode.cost) {
                distance[nextNode.idx] = distance[node.idx] + nextNode.cost
                queue.add(Node(nextNode.idx, distance[nextNode.idx]))
            }
        }
    }
}

data class Node(
    val idx: Int,
    val cost: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.cost - other.cost
    }
}
