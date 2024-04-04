package boj.boj_1197

private lateinit var parent: IntArray
fun main() {
    val (v, e) = readln().split(" ")
    parent = IntArray(v.toInt() + 1)
    for (idx in 1..v.toInt()) {
        parent[idx] = idx
    }
    val edges = mutableListOf<Edge>()
    for (node in 0 until e.toInt()) {
        val (from, to, cost) = readln().split(" ")
        edges.add(Edge(from.toInt(), to.toInt(), cost.toInt()))
    }

    edges.sort()
    var answer = 0
    for (idx in 0 until edges.size) {
        val edge = edges[idx]
        if (findParent(edge.from) != findParent(edge.to)) {
            union(edge.from, edge.to)
            answer += edge.cost
        }
    }
    println(answer)

}

fun union(
    x: Int,
    y: Int
) {
    val findX = findParent(x)
    val findY = findParent(y)

    if (findX > findY) {
        parent[findX] = findY
    } else {
        parent[findY] = findX
    }
}

fun findParent(
    x: Int
): Int {
    if (parent[x] == x) {
        return x
    }
    return findParent(parent[x])
}

data class Edge(
    val from: Int,
    val to: Int,
    val cost: Int
) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return this.cost - other.cost
    }
}
