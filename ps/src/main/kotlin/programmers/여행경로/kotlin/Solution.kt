package programmers.여행경로.kotlin

class Solution {
    private lateinit var visited: BooleanArray
    private lateinit var tickets: Array<Array<String>>
    private val allRoutes = mutableListOf<String>()

    fun solution(tickets: Array<Array<String>>): Array<String> {
        this.tickets = tickets
        this.visited = BooleanArray(tickets.size) { false }

        dfs("ICN", mutableListOf("ICN"))
        allRoutes.sort()
        return allRoutes[0].split(", ")
            .toTypedArray()
    }

    private fun dfs(
        start: String,
        routes: MutableList<String>,
    ) {
        if (routes.size == tickets.size + 1) {
            allRoutes.add(routes.joinToString(", "))
            return
        }

        for (idx in tickets.indices) {
            if (start == tickets[idx][0] && !visited[idx]) {
                visited[idx] = true
                val next = tickets[idx][1]
                routes.add(next)
                dfs(next, routes)
                routes.removeAt(routes.size - 1)
                visited[idx] = false
            }
        }
    }
}

fun main() {
    val tickets: Array<Array<String>> = arrayOf(
        arrayOf("ICN", "SFO"),
        arrayOf("ICN", "ATL"),
        arrayOf("SFO", "ATL"),
        arrayOf("ATL", "ICN"),
        arrayOf("ATL", "SFO")
    )

    val solution = Solution()
    val result = solution.solution(tickets)
    println(result.joinToString(", "))
}
