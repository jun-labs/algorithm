package boj.boj_1987

fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ")
        .map { it.toInt() }

    val answer = mutableListOf<Int>()
    for (number in numbers) {
        if (isPrimeNumber(number)) {
            answer.add(number)
        }
    }
    println(answer.size)
}

fun isPrimeNumber(number: Int): Boolean {
    if (number == 1) {
        return false
    }
    for (idx in 2..<number) {
        if (number % idx == 0) {
            return false
        }
    }
    return true
}
