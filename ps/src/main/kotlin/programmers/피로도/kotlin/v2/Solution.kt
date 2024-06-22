package programmers.피로도.kotlin.v2

import kotlin.math.max

class Solution {
    private lateinit var dungeons: Array<IntArray>

    fun solution(
        k: Int,
        _dungeons: Array<IntArray>,
    ): Int {
        dungeons = _dungeons
        val visited = BooleanArray(_dungeons.size)
        return dfs(k, 0, visited)
    }

    private fun dfs(
        k: Int,
        count: Int,
        visited: BooleanArray,
    ): Int {
        var max = count
        for (next in dungeons.indices) {
            val dungeon = dungeons[next]
            if (!visited[next] && k >= dungeon[0]) {
                visited[next] = true
                max = max(max, dfs(k - dungeon[1], count + 1, visited))
                visited[next] = false
            }
        }
        return max
    }
}
