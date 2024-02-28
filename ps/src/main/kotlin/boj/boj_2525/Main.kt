package boj.boj_2525

fun main() {
    val numbers = readLine()?.split(" ")
    val hour = numbers?.get(0)?.toInt()
    val minutes = numbers?.get(1)?.toInt()
    val addTime = readLine()?.toInt()

    val time = hour!! * 60 + minutes!! + addTime!!
    var answerHour = time / 60 % 24
    val answerMinutes = time % 60
    println("$answerHour $answerMinutes")
}
