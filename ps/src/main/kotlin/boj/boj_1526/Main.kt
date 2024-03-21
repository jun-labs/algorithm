package boj.boj_1526

fun main() {
    var n = readln().toInt()

    while (n >= 4) {
        if (isValid(n)) {
            println(n)
            return
        }
        n -= 1
    }
}

fun isValid(number: Int): Boolean {
    return number.toString()
        .all { it == '4' || it == '7' }
}
