package boj.boj_1141.kotlin

fun main() {
    val n = readln().toInt()
    val words = mutableListOf<String>()
    for (input in 0 until n) {
        words.add(readln())
    }

    words.sortWith(compareBy<String> { it.length }.thenBy { it })

    val result = mutableListOf<String>()
    outer@ for (i in 0 until words.size) {
        for (j in i + 1 until words.size) {
            if (words[j].startsWith(words[i])) {
                continue@outer
            }
        }
        result.add(words[i])
    }

    println(result.size)
}
