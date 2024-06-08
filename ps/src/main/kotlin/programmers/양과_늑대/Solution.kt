package programmers.양과_늑대

import kotlin.math.max

class Solution {
    private var answer = 0
    private lateinit var info: IntArray
    private val nodes: Array<MutableList<Int>> = Array(17) { mutableListOf() }

    fun solution(
        _info: IntArray,
        edges: Array<IntArray>,
    ): Int {
        this.info = _info
        for (edge in edges) {
            nodes[edge[0]].add(edge[1])
        }
        dfs(0, 1, 0, mutableSetOf())
        return answer
    }

    private fun dfs(
        node: Int,
        sheep: Int,
        wolf: Int,
        nodes: MutableSet<Int>,
    ) {
        answer = max(answer, sheep)

        val linkedNodes = mutableSetOf<Int>()
        linkedNodes.addAll(this.nodes[node])
        linkedNodes.addAll(nodes)
        linkedNodes.remove(node)

        for (next in linkedNodes) {
            val nextSheep = sheep + if (info[next] == 0) 1 else 0
            val nextWolf = wolf + if (info[next] == 1) 1 else 0
            if (nextSheep > nextWolf) {
                dfs(next, nextSheep, nextWolf, linkedNodes)
            }
        }
    }
}
