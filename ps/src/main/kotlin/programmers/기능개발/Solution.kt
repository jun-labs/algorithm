package programmers.기능개발

import java.util.*
import kotlin.math.ceil

class Solution {
    val jobs = LinkedList<Job>()

    fun solution(
        progresses: IntArray,
        speeds: IntArray
    ): IntArray {
        val answer = ArrayList<Int>()
        for (idx in progresses.indices) {
            jobs.add(Job(progresses[idx], speeds[idx]))
        }

        var time = 0
        while (jobs.isNotEmpty()) {
            var count = 0
            while (isWorking()) {
                time++

                // 한 번의 배포
                while (jobs.isNotEmpty() && isDoneAfterTime(time)) {
                    jobs.poll()
                    count++
                }
                if (count != 0) {
                    answer.add(count)
                    break
                }
            }
        }
        return answer.toIntArray()
    }

    private fun isDoneAfterTime(time: Int) = jobs.peek().work + jobs.peek().speed * time >= 100

    private fun isWorking() = jobs.peek().work < 100
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

class Solution2 {
    fun solution(
        progresses: IntArray,
        speeds: IntArray
    ): IntArray {
        val releaseDays = progresses.indices.map { index ->
            ceil((100.0 - progresses[index]) / speeds[index]).toInt()
        }
        val answer = mutableListOf<Int>()
        var maxDay = releaseDays[0]
        var count = 1

        for (i in 1 until releaseDays.size) {
            if (releaseDays[i] <= maxDay) {
                count++
            } else {
                answer.add(count)
                count = 1
                maxDay = releaseDays[i]
            }
        }
        answer.add(count)
        return answer.toIntArray()
    }
}
