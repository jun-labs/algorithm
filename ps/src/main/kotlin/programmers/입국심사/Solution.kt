package programmers.입국심사

class Solution {
    fun solution(
        n: Int,
        times: IntArray,
    ): Long {
        times.sort()
        var answer = 0L
        var start = 0L
        var end = n * times.last().toLong()
        var mid: Long
        while (start <= end) {
            mid = (start + end) / 2
            val totalCount = times.fold(0L) { count, time ->
                count + (mid / time)
            }
            if (totalCount < n) {
                start = mid + 1
            } else {
                end = mid - 1
                answer = mid
            }
        }
        return answer
    }
}
