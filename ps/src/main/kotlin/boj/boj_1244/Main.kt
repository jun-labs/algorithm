package boj.boj_1244

fun main() {
    val n = readln().toInt()
    val bulbs = readln().split(" ")
        .map { it.toInt() }
        .toIntArray()

    val studentCount = readln().toInt()

    repeat(studentCount) {
        val (gender, number) = readln().split(" ")
            .map { it.toInt() }

        if (gender == 1) {
            for (idx in bulbs.indices) {
                if ((idx + 1) % number == 0) {
                    bulbs[idx] = bulbs[idx].xor(1)
                }
            }
        } else {
            var left = number - 1
            var right = number - 1
            while (left > 0 && right < n - 1) {
                if (bulbs[left - 1] != bulbs[right + 1]) {
                    break
                }
                left--
                right++
            }
            for (idx in left..right) {
                bulbs[idx] = bulbs[idx].xor(1)
            }
        }
    }

    for (idx in bulbs.indices) {
        val bulb = bulbs[idx]
        print("$bulb ")
        if ((idx + 1) % 20 == 0) {
            println()
        }
    }
}
