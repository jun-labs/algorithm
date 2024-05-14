package boj.boj_12865

fun main() {
    val (n, k) = readln().split(" ")
        .map { it.toInt() }

    val bags = mutableListOf<Bag>()

    bags.add(Bag(0, 0))
    for (idx in 0 until n) {
        val (w, v) = readln().split(" ")
            .map { it.toInt() }
        bags.add(Bag(w, v))
    }

    val dp = Array(n + 1) { IntArray(k + 1) }
    for (i in 1..n) {
        val bag = bags[i]
        for (j in 0 until k + 1) {
            if (j < bag.weight) {
                dp[i][j] = dp[i - 1][j]
            } else {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i - 1][j - bag.weight] + bag.value)
            }
        }
    }
    println(dp[n][k])
}

class Bag(
    val weight: Int,
    val value: Int,
)
