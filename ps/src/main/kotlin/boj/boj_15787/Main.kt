package boj.boj_15787

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val trains = Array(n + 1) { IntArray(20) }
    val set = mutableSetOf<String>()

    repeat(m) {
        val input = readln().split(" ").map { it.toInt() }
        val command = input[0]
        val i = input[1]
        val train = trains[i]

        when (command) {
            1 -> {
                val x = input[2] - 1
                train[x] = 1
            }

            2 -> {
                val x = input[2] - 1
                train[x] = 0
            }

            3 -> {
                for (j in 19 downTo 1) {
                    train[j] = train[j - 1]
                }
                train[0] = 0
            }

            4 -> {
                for (j in 0..18) {
                    train[j] = train[j + 1]
                }
                train[19] = 0
            }
        }
    }

    for (idx in 1..n) {
        val str = trains[idx].joinToString("")
        set.add(str)
    }
    println(set.size)
}
