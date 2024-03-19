package boj.boj_1100

fun main() {
    var answer = 0
    for (x in 0 until 8) {
        val row = readln()
        for (y in 0 until 8) {
            if ((x + y) % 2 == 0 && row[y] == 'F') {
                answer++
            }
        }
    }
    println(answer)
}
