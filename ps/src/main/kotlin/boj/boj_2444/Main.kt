package boj.boj_2444

fun main() {
    val n = readLine()?.toIntOrNull() ?: 0
    printDiamond(n)
}

fun printDiamond(n: Int) {
    for (i in 0 until n) {
        for (j in 0 until n - 1 - i) {
            print(" ")
        }
        for (j in 0 until 2 * i + 1) {
            print("*")
        }
        println()
    }
    for (i in n - 2 downTo 0) {
        for (j in 0 until n - i - 1) {
            print(" ")
        }
        for (j in 0 until 2 * i + 1) {
            print("*")
        }
        println()
    }
}
