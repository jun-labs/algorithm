package programmers.체육복

class Solution {
    fun solution(
        n: Int,
        lost: IntArray,
        reserve: IntArray
    ): Int {
        var answer = n - lost.size
        lost.sort()
        reserve.sort()

        val lostStudents = lost.toMutableList()
        val reservedStudents = reserve.toMutableList()


        val iterator = lostStudents.iterator()
        while (iterator.hasNext()) {
            val student = iterator.next()
            if (student in reservedStudents) {
                answer++
                iterator.remove()
                reservedStudents.remove(student)
            }
        }

        for (student in lostStudents) {
            when {
                student - 1 in reservedStudents -> {
                    answer++
                    reservedStudents.remove(student - 1)
                }

                student + 1 in reservedStudents -> {
                    answer++
                    reservedStudents.remove(student + 1)
                }
            }
        }
        return answer
    }
}
