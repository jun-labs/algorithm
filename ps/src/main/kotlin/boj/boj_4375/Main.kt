package boj.boj_4375

fun main() {
    while (true) {
        val str = readlnOrNull() ?: break
        val number = str.toInt()
        var currentNumber = 1
        var count = 1
        while (currentNumber % number != 0) {
            currentNumber = (currentNumber * 10 + 1) % number
            count++
        }
        println(count)
    }
}
