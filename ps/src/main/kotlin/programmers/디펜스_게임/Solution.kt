package programmers.디펜스_게임

import java.util.Collections
import java.util.PriorityQueue
import java.util.Queue

class Solution {
    private val queue: Queue<Int> = PriorityQueue(Collections.reverseOrder())

    fun solution(
        n: Int,
        k: Int,
        enemy: IntArray,
    ): Int {
        var life = n
        var defenceTicket = k
        for ((turn, value) in enemy.withIndex()) {
            queue.add(value)
            life -= value
            if (life < 0) {
                if (defenceTicket >= 1) {
                    defenceTicket -= 1
                    life += queue.poll()
                } else {
                    return turn
                }
            }
        }
        return enemy.size
    }
}
