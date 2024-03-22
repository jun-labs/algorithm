package programmers.이중우선순위큐

import java.util.*

class Solution {
    private val minQueue = PriorityQueue<Int>()
    private val maxQueue = PriorityQueue<Int>(Collections.reverseOrder())

    fun solution(operations: Array<String>): IntArray {
        operations.forEach { operation ->
            val (command, value) = operation.split(" ")
            val intValue = value.toInt()

            when (command) {
                "I" -> {
                    minQueue.add(intValue)
                    maxQueue.add(intValue)
                }

                "D" -> {
                    if (intValue == 1) {
                        val maxValue = maxQueue.poll()
                        minQueue.remove(maxValue)
                    } else if (intValue == -1) {
                        val minValue = minQueue.poll()
                        maxQueue.remove(minValue)
                    }
                }
            }
        }
        return if (minQueue.isNotEmpty() && maxQueue.isNotEmpty()) {
            intArrayOf(maxQueue.poll(), minQueue.poll())
        } else {
            intArrayOf(0, 0)
        }
    }
}
