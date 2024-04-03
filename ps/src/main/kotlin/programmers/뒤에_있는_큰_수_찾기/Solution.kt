package programmers.뒤에_있는_큰_수_찾기

import java.util.Stack

class Solution {
    fun solution(numbers: IntArray): IntArray {
        val stack = Stack<Int>()
        val answer = IntArray(numbers.size)
        stack.push(0)

        for (idx in 1 until numbers.size) {
            while (stack.isNotEmpty() && numbers[stack.peek()] < numbers[idx]) {
                answer[stack.pop()] = numbers[idx]
            }
            stack.push(idx)
        }

        while (stack.isNotEmpty()) {
            answer[stack.pop()] = -1
        }
        return answer
    }
}
