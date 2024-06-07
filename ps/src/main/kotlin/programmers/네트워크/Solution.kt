package programmers.네트워크

class Solution {
    private lateinit var visited: Array<Boolean>
    private lateinit var computers: Array<IntArray>

    fun solution(
        n: Int,
        computers: Array<IntArray>,
    ): Int {
        visited = Array(n) { false }
        this.computers = computers

        var answer = 0
        for (node in 0 until n) {
            if (!visited[node]) {
                dfs(node)
                answer++
            }
        }
        return answer
    }

    private fun dfs(node: Int) {
        visited[node] = true
        for (next in visited.indices) {
            if (node == next) {
                continue
            }
            if (!visited[next] && computers[node][next] > 0) {
                dfs(next)
            }
        }
    }
}
