package programmers.입국심사

class Solution {
    fun solution(
        n: Int,
        times: IntArray
    ): Long {
        times.sort()
        var answer: Long = 0

        var start: Long = 0
        var end: Long = n.toLong() * times.last()
        var mid: Long
        while (start <= end) {
            val mid: Long = (start + end) / 2
            val count: Long = times.fold(0L) { total, time ->
                total + (mid / time)
            }

            if (count < n) {
                start = mid + 1
            } else {
                answer = minOf(answer, mid)
                end = mid - 1
            }
        }
        return answer
    }
}
