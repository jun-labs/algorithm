package programmers.타겟넘버

import java.util.*

class Solution {
    private val queue = LinkedList<Number>()

    fun solution(
        numbers: IntArray,
        target: Int
    ): Int {
        val size = numbers.size
        var answer = 0
        queue.add(Number(0, 0))
        while (queue.isNotEmpty()) {
            val number = queue.poll()
            if (number.order > size) {
                continue
            }

            if (number.order == size) {
                if (number.value == target) {
                    answer++
                }
            } else {
                queue.add(Number(number.value + numbers[number.order], number.order + 1))
                queue.add(Number(number.value - numbers[number.order], number.order + 1))
            }
        }
        return answer
    }
}

data class Number(
    val value: Int,
    val order: Int
)
