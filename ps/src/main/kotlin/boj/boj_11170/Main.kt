package boj.boj_11170

fun main() {
    val number = readln().toInt()
    for (idx in 0 until number) {
        val (start, end) = readln().split(" ")
        println(countZero(start, end))
    }
}

fun countZero(
    start: String,
    end: String
): Int {
    var count = 0
    for (number in start.toInt() until end.toInt() + 1) {
        number.toString().forEach {
            if (it == '0') {
                count += 1
            }
        }
    }
    return count
}
