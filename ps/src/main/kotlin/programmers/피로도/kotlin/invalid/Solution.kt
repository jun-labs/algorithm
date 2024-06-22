package programmers.피로도.kotlin.invalid

import kotlin.math.max

class Solution {
    private lateinit var dungeons: Array<IntArray>
    private var answer = -1

    fun solution(
        k: Int,
        _dungeons: Array<IntArray>,
    ): Int {
        dungeons = _dungeons
        for (idx in 0 until dungeons.size) {
            val visited = BooleanArray(dungeons.size)
            visited[idx] = true
            if (k - dungeons[idx][1] >= 0) {
                dfs(k - dungeons[idx][1], 1, visited)
            } else {
                dfs(k, 1, visited)
            }
        }
        return answer
    }

    private fun dfs(
        k: Int,
        count: Int,
        visited: BooleanArray,
    ) {
        answer = max(answer, count)
        for (next in dungeons.indices) {
            val dungeon = dungeons[next]
            if (!visited[next] && k >= dungeon[0]) {
                visited[next] = true
                dfs(k - dungeon[1], count + 1, visited)
            }
        }
    }
}
