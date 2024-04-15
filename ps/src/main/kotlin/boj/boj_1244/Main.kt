package boj.boj_1244

fun main() {
    val n = readln().toInt()
    val bulbs = readln().split(" ")
        .map { it.toInt() }
        .toIntArray()

    val students = readln().toInt()
    repeat(students) {
        val (gender, number) = readln().split(" ")
            .map { it.toInt() }

        if (gender == 1) {
            for (i in number - 1 until n step number) {
                bulbs[i] = bulbs[i].xor(1)
            }
        } else if (gender == 2) {
            var left = number - 1
            var right = number - 1
            while (left > 0 && right < n - 1 && bulbs[left - 1] == bulbs[right + 1]) {
                left--
                right++
            }
            for (idx in left..right) {
                bulbs[idx] = bulbs[idx].xor(1)
            }
        }
    }

    bulbs.forEachIndexed { index, state ->
        print("$state ")
        if ((index + 1) % 20 == 0) println()
    }
}
