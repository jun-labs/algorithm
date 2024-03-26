package boj.boj_1681

fun main() {
    val (n, l) = readln().split(" ")
    var count = 0
    var number = 1

    while (count < n.toInt()) {
        if (!number.toString().contains(l)) {
            count++
            if (count == n.toInt()) {
                println(number)
                return
            }
        }
        number++
    }
}
