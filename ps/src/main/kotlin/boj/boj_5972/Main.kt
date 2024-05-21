package boj.boj_5972

import java.util.PriorityQueue

fun main() {
    val (n, m) = readln().split(" ")
        .map { it.toInt() }
    val nodes = Array(n + 1) { mutableListOf<Node>() }
    val visited = BooleanArray(n + 1)
    val distance = IntArray(n + 1) { 100_000_000 }
    for (idx in 1..n) {
        nodes[idx] = mutableListOf()
    }

    for (idx in 0 until m) {
        val (start, end, cost) = readln().split(" ")
            .map { it.toInt() }
        nodes[start].add(Node(end, cost))
        nodes[end].add(Node(start, cost))
    }
    dijkstra(visited, distance, nodes)
    println(distance[n])
}

fun dijkstra(
    visited: BooleanArray,
    distance: IntArray,
    nodes: Array<MutableList<Node>>,
) {
    val queue = PriorityQueue<Node>()
    distance[1] = 0
    queue.add(Node(1, 0))

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        if (!visited[node.idx]) {
            visited[node.idx] = true
        } else {
            continue
        }

        for (idx in 0 until nodes[node.idx].size) {
            val next = nodes[node.idx][idx]
            if (distance[next.idx] > distance[node.idx] + next.cost) {
                distance[next.idx] = distance[node.idx] + next.cost
                queue.add(Node(next.idx, distance[next.idx]))
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
