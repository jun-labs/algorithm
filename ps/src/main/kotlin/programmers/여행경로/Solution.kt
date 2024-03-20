package programmers.여행경로

class Solution {
    companion object {
        private const val START = 0
        private const val NEXT = 1
    }

    private var totalCityCount = 0
    private var tickets: Array<Array<String>>? = null
    private var visited: Array<Boolean>? = null
    private val allRoutes = mutableListOf<String>()

    fun solution(tickets: Array<Array<String>>): Array<String> {
        totalCityCount = tickets.size
        this.tickets = tickets
        visited = Array(totalCityCount) { false }
        dfs("ICN", "ICN", 0)
        allRoutes.sort()
        return allRoutes[0].split(" ")
            .toTypedArray()
    }

    private fun dfs(
        start: String,
        route: String,
        count: Int
    ) {
        if (count == totalCityCount) {
            allRoutes.add(route)
            return
        }
        for (idx in 0 until totalCityCount) {
            if (start == tickets!![idx][START] && !visited!![idx]) {
                visited!![idx] = true
                val next = tickets!![idx][NEXT]
                dfs(next, "$route $next", count + 1)
                visited!![idx] = false
            }
        }
    }
}
