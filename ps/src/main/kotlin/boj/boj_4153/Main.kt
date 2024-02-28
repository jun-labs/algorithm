package boj.boj_4153

fun main() {
    while (true) {
        val numbers = readLine()?.split(" ")
            ?.map { it.toInt() }
            ?.sortedDescending()
            ?: mutableListOf()

        if (numbers.contains(0)) {
            break
        }

        val biggest = numbers[0]
        val other = numbers[1]
        val theOther = numbers[2]

        if (biggest * biggest == other * other + theOther * theOther) {
            println("right")
        } else {
            println("wrong")
        }
    }
}
