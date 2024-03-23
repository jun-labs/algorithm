package programmers.기능개발

import java.util.*

class Solution {
    private val jobs = LinkedList<Job>()

    fun solution(
        progresses: IntArray,
        speeds: IntArray
    ): IntArray {
        val answer = mutableListOf<Int>()
        for (idx in progresses.indices) {
            jobs.add(Job(progresses[idx], speeds[idx]))
        }

        var time = 0
        while (jobs.isNotEmpty()) {
            var count = 0
            while (isWorking(time)) {
                time++
                while (jobs.isNotEmpty() && isDone(time)) {
                    jobs.poll()
                    count++
                }
                if (count != 0) {
                    answer.add(count)
                }
                break
            }
        }
        return answer.toIntArray()
    }

    private fun isWorking(time: Int) = (jobs.peek().work + jobs.peek().speed * time) < 100

    private fun isDone(time: Int) = (jobs.peek().work + jobs.peek().speed * time) >= 100
}

data class Job(
    var work: Int,
    val speed: Int
)

fun main() {
    val progresses = intArrayOf(93, 30, 55)
    val speeds = intArrayOf(1, 30, 5)
    val solution = Solution()
    solution.solution(progresses, speeds).forEach { println(it) }
}
