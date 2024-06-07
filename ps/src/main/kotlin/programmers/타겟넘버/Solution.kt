package programmers.타겟넘버

import java.util.LinkedList

class Solution {
    private val queue = LinkedList<Number>()

    fun solution(
        numbers: IntArray,
        target: Int,
    ): Int {
        var answer = 0

        queue.add(Number(0, 0))
        while (queue.isNotEmpty()) {
            val number = queue.poll()
            if (number.order > numbers.size) {
                continue
            }

            if (number.order == numbers.size) {
                if (number.value == target) {
                    answer++
                }
            } else {
                queue.add(Number(number.nextValue(numbers[number.order]), number.nextOrder()))
                queue.add(Number(number.nextValue(-numbers[number.order]), number.nextOrder()))
            }
        }
        return answer
    }
}

data class Number(
    val value: Int,
    val order: Int,
) {
    fun nextValue(nextValue: Int): Int {
        return value + nextValue
    }

    fun nextOrder(): Int {
        return order + 1
    }
}
