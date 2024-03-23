package programmers.타겟넘버

import java.util.*

class Solution {
    private val queue = LinkedList<Number>()

    fun solution(
        numbers: IntArray,
        target: Int
    ): Int {
        var answer = 0
        val size = numbers.size

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
                queue.add(Number(number.value + numbers[number.order], number.nextOrder()))
                queue.add(Number(number.value - numbers[number.order], number.nextOrder()))
            }
        }
        return answer
    }
}

data class Number(
    val value: Int,
    val order: Int
) {
    fun nextOrder(): Int {
        return order + 1
    }
}
