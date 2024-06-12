package boj.boj_17427

fun main() {
    val n = readln().toInt()

    val answer = LongArray(n + 1) { 0 }
    for (number in 1..n) {
        for (element in number..n step number) {
            answer[element] += number.toLong()
        }
    }
    println(answer.sum())
}
