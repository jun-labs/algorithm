package programmers.네트워크

class Solution {
    private var visited: Array<Boolean>? = null
    private var computers: Array<IntArray>? = null

    fun solution(
        n: Int,
        computers: Array<IntArray>
    ): Int {
        var answer = 0
        this.computers = computers
        visited = Array(n) { false }

        for (node in 0 until n) {
            if (!visited!![node]) {
                visited!![node] = true
                dfs(node)
                answer++
            }
        }
        return answer
    }

    private fun dfs(node: Int) {
        for (column in 0 until computers!![node].size) {
            if (!visited!![column] && computers!![node][column] > 0) {
                visited!![column] = true
                dfs(column)
            }
        }
    }
}
