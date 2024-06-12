package boj.boj_1713

fun main() {
    val n = readln().toInt()
    val totalCount = readln().toInt()
    val students = readln().split(" ")
        .map { it.toInt() }

    val frames = mutableListOf<Candidate>()
    var time = 0

    for (student in students) {
        time++
        val findStudent = frames.find { it.student == student }
        if (findStudent != null) {
            findStudent.votes++
        } else {
            if (frames.size < n) {
                frames.add(Candidate(student, 1, time))
            } else {
                frames.sortWith(compareBy({ it.votes }, { it.time }))
                frames.removeAt(0)
                frames.add(Candidate(student, 1, time))
            }
        }
    }

    val result = frames.map { it.student }
        .sorted()
    println(result.joinToString(" "))
}

data class Candidate(
    val student: Int,
    var votes: Int,
    var time: Int,
)
