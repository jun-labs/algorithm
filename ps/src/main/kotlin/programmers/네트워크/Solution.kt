package programmers.네트워크

class Solution {
    private var visited: Array<Boolean>? = null
    private var computers: Array<IntArray>? = null

    fun solution(
        n: Int,
        computers: Array<IntArray>
    ): Int {
        var answer = 0
        visited = Array(n) { false }
        this.computers = computers

        for (node in 0 until n) {
            if (!visited!![node]) {
                visited!![node] = true
                dfs(node)
                answer++
            }
        }
        return answer
    }

    private fun dfs(visitedNode: Int) {
        for (node in 0 until visited!!.size) {
            if (!visited!![node] && computers!![visitedNode][node] > 0) {
                visited!![node] = true
                dfs(node)
            }
        }
    }
}
