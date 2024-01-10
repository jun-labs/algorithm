package programmers.디펜스_게임

import java.util.*

class Solution {
    private val queue: Queue<Int> = PriorityQueue(Collections.reverseOrder())

    fun solution(
        n: Int,
        k: Int,
        enemy: IntArray
    ): Int {
        var life = n
        var lifeTicket = k

        for ((turn, value) in enemy.withIndex()) {
            queue.add(value)
            life -= value
            if (life < 0) {
                if (lifeTicket >= 1 && queue.isNotEmpty()) {
                    lifeTicket -= 1
                    life += queue.poll()
                } else {
                    return turn
                }
            }
        }
        return enemy.size
    }
}

fun main() {
    val n = 7
    val k = 3
    val enemy = intArrayOf(4, 2, 4, 5, 3, 3, 1)
    val solution = Solution()
    println(solution.solution(n, k, enemy))
}
