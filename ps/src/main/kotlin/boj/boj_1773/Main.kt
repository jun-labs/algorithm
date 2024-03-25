package boj.boj_1773

fun main() {
    val (n, c) = readln().split(" ")
        .map { it.toInt() }
    val visited = BooleanArray(c + 1) { false }

    repeat(n) {
        val period = readln().toInt()
        if (!visited[period]) {
            var time = period
            while (time <= c) {
                visited[time] = true
                time += period
            }
        }
    }

    val totalTimes = visited.count { it }
    println(totalTimes)
}
