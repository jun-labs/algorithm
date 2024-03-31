package programmers.순위

class Solution {
    fun solution(
        n: Int,
        results: Array<IntArray>
    ): Int {
        val win = Array(n + 1) { BooleanArray(n + 1) }
        val lose = Array(n + 1) { BooleanArray(n + 1) }

        for (result in results) {
            val winner = result[0]
            val loser = result[1]
            win[winner][loser] = true
            lose[loser][winner] = true
        }

        for (x in 1..n) {
            for (y in 1..n) {
                for (z in 1..n) {
                    if (win[y][x] && win[x][z]) {
                        win[y][z] = true
                    }
                    if (lose[y][x] && lose[x][z]) {
                        lose[y][z] = true
                    }
                }
            }
        }

        var answer = 0
        for (x in 1..n) {
            var count = 0
            for (y in 1..n) {
                if (win[x][y] || lose[x][y]) {
                    count++
                }
            }
            if (count == n - 1) {
                answer++
            }
        }
        return answer
    }
}
