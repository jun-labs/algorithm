package programmers.전력망을_둘로_나누기

import kotlin.math.abs

class Solution {
    private lateinit var graph: Array<MutableList<Int>>
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer = n

        graph = Array(n + 1) { mutableListOf() }
        for (wire in wires) {
            graph[wire[0]].add(wire[1])
            graph[wire[1]].add(wire[0])
        }

        for (wire in wires) {
            val visited = BooleanArray(n + 1) { false }
            val count = dfs(wire[0], wire[1], visited)
            answer = minOf(answer, abs(count - (n - count)))
        }
        return answer
    }

    private fun dfs(
        node: Int,
        skip: Int,
        visited: BooleanArray
    ): Int {
        visited[node] = true
        var count = 1
        for (next in graph[node]) {
            if (!visited[next] && next != skip) {
                count += dfs(next, skip, visited)
            }
        }
        return count
    }
}
