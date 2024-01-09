package programmers.요격_시스템

class Solution {
    fun solution(targets: Array<IntArray>): Int {
        var answer: Int = 0
        var max = -1
        val lines = mutableListOf<Line>()
        for (line in targets) {
            lines.add(Line(line[0], line[1]))
        }
        lines.sort()

        for (line in lines) {
            if (line.start >= max) {
                answer++
                max = line.end
            }
        }
        return answer
    }
}

class Line(
    val start: Int,
    val end: Int
) : Comparable<Line> {

    override fun compareTo(other: Line): Int {
        return end - other.end
    }
}
