package programmers.네트워크

class Solution {
    private lateinit var visited: Array<Boolean>
    private lateinit var computers: Array<IntArray>

    fun solution(
        n: Int,
        computers: Array<IntArray>
    ): Int {
        var answer = 0
        visited = Array(n) { false }
        this.computers = computers

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
        for (next in 0 until visited.size) {
            if (!visited[next] && computers[node][next] > 0) {
                visited[next] = true
                dfs(next)
            }
        }
    }
}

