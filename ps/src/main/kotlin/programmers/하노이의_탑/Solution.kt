package programmers.하노이의_탑

class Solution {
    private val movements: MutableList<IntArray> = mutableListOf()
    fun solution(n: Int): Array<IntArray> {
        hanoi(n, 1, 3, 2)
        val answer = Array(movements.size) { IntArray(2) }
        for (idx in answer.indices) {
            answer[idx] = movements[idx]
        }
        return answer
    }

    private fun hanoi(
        n: Int,
        from: Int,
        to: Int,
        via: Int
    ) {
        val movement = intArrayOf(from, to)
        if (n == 1) {
            movements.add(movement)
            return
        }
        hanoi(n - 1, from, via, to)
        movements.add(movement)
        hanoi(n - 1, via, to, from)
    }
}
