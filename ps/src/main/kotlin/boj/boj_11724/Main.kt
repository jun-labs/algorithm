package boj.boj_11724

private lateinit var nodes: Array<MutableList<Int>>
private lateinit var visited: BooleanArray

fun main() {

    val (n, m) = readln().split(" ")
        .map { it.toInt() }
    nodes = Array(n + 1) { mutableListOf() }
    visited = BooleanArray(n + 1)
    for (idx in 0 until m) {
        val (a, b) = readln().split(" ")
            .map { it.toInt() }
        nodes[a].add(b)
        nodes[b].add(a)
    }

    var answer = 0
    for (node in 1..n) {
        if (!visited[node]) {
            dfs(node)
            answer++
        }
    }
    println(answer)
}

fun dfs(node: Int) {
    visited[node] = true
    val linkedNOde = nodes[node]
    for (next in linkedNOde) {
        if (!visited[next]) {
            dfs(next)
        }
    }
}
