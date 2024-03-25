package boj.boj_1233

fun main() {
    val (s1, s2, s3) = readln().split(' ')
        .map { it.toInt() }
    val sumMap = mutableMapOf<Int, Int>()
    for (i in 1..s1) {
        for (j in 1..s2) {
            for (k in 1..s3) {
                val sum = i + j + k
                sumMap[sum] = sumMap.getOrDefault(sum, 0) + 1
            }
        }
    }

    val max = sumMap.maxBy { it.value }.value
    val answer = sumMap.filter { it.value == max }
        .minBy { it.key }.key
    println(answer)
}
