package programmers.피로도.kotlin.v1

import kotlin.math.max

class Solution {
    private lateinit var dungeons: Array<IntArray>
    private var answer = -1

    fun solution(
        k: Int,
        _dungeons: Array<IntArray>,
    ): Int {
        dungeons = _dungeons
        val visited = BooleanArray(_dungeons.size)
        dfs(k, 0, visited)
        return answer
    }

    private fun dfs(
        k: Int,
        count: Int,
        visited: BooleanArray,
    ): Int {
        answer = max(answer, count)
        for (next in dungeons.indices) {
            val dungeon = dungeons[next]
            if (!visited[next] && k >= dungeon[0]) {
                visited[next] = true
                dfs(k - dungeon[1], count + 1, visited)
                visited[next] = false
            }
        }
        return count
    }
}
