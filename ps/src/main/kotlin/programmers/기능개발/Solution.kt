package programmers.기능개발

import java.util.concurrent.LinkedBlockingDeque
import kotlin.math.ceil

class Solution {
    var answer = mutableListOf<Int>()
    fun solution(
        progresses: IntArray,
        speeds: IntArray
    ): IntArray {
        val functions = LinkedBlockingDeque<Function>()
        progresses.indices.forEach { index ->
            functions.add(Function(progresses[index], speeds[index]))
        }

        while (functions.isNotEmpty()) {
            for (function in functions) {
                function.progress += function.speed
            }
            val function = functions.peekFirst()
            while (functions.isNotEmpty()) {
                var count = 0
                if (function.progress >= 100) {
                    functions.pollFirst()
                    count++
                    if (functions.isNotEmpty()) {
                        for (next in functions) {
                            if (functions.peekFirst().progress >= 100) {
                                functions.pollFirst()
                                count++
                            }
                            if (functions.isEmpty()) {
                                break
                            }
                        }
                    }
                    if (count > 0)
                        answer.add(count)
                }
                break
            }
        }
        return answer.toIntArray()
    }
}

data class Function(
    var progress: Int,
    var speed: Int
)

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
