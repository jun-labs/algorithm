package programmers.섬_연결하기

class Solution {
    companion object {
        private const val CITY_A = 0
        private const val CITY_B = 1
        private const val COST = 2
        private lateinit var parent: IntArray
    }

    fun solution(
        n: Int,
        costs: Array<IntArray>
    ): Int {
        parent = IntArray(n) { it }
        costs.sortBy { it[COST] }

        var answer = 0
        for (cost in costs) {
            if (find(cost[CITY_A]) != find(cost[CITY_B])) {
                union(cost[CITY_A], cost[CITY_B])
                answer += cost[COST]
            }
        }
        return answer
    }

    private fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    private fun union(
        x: Int,
        y: Int
    ) {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX < rootY) {
            parent[rootY] = rootX
        } else {
            parent[rootX] = rootY
        }
    }
}
