package boj.boj_17614

fun main() {
    val number = readln().toInt()
    var answer = 0
    for (idx in 1 until number + 1) {
        answer += count369(idx)
    }
    println(answer)
}

fun count369(number: Int): Int {
    var count = 0
    number.toString().forEach { char ->
        if (char == '3' || char == '6' || char == '9') {
            count++
        }
    }
    return count
}
