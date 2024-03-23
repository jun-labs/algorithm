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
    var temp = number
    while (temp > 0) {
        val remain = temp % 10
        if (remain == 3) {
            count++
        } else if (remain == 6) {
            count++
        } else if (remain == 9) {
            count++
        }
        temp /= 10
    }
    return count
}
