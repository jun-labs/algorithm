package programmers.테이블_해시_함수

class Solution {
    fun solution(
        data: Array<IntArray>,
        col: Int,
        row_begin: Int,
        row_end: Int
    ): Int {
        var answer = 0
        val order = col - 1

        data.sortWith { o1, o2 ->
            if (o1[order] == o2[order]) o2[0] - o1[0]
            else o1[order] - o2[order]
        }

        for (idx in row_begin - 1 until row_end) {
            val sum = data[idx].sumOf { it % (idx + 1) }
            answer = answer xor sum
        }

        return answer
    }
}
