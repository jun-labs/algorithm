package programmers.하노이의_탑

class Solution {
    private lateinit var seq: MutableList<IntArray>
    fun solution(n: Int): Array<IntArray> {
        seq = mutableListOf()
        hanoi(n, 1, 3, 2)
        val answer = Array(seq.size) { IntArray(2) }

        for (idx in 0 until seq.size) {
            answer[idx] = seq[idx]
        }
        return answer
    }

    fun hanoi(
        n: Int,
        from: Int,
        to: Int,
        via: Int
    ) {
        val movement = intArrayOf(from, to)
        if (n == 1) {
            seq.add(movement)
        } else {
            hanoi(n - 1, from, via, to)
            seq.add(movement)
            hanoi(n - 1, via, to, from)
        }
    }
}
