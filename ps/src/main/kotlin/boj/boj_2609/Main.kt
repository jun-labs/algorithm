package boj.boj_2609

fun main() {
    val (a, b) = readln().split(" ")
        .map { it.toInt() }
    val gcd = getGcd(a, b)
    val lcm = a * b / gcd

    println(gcd)
    println(lcm)
}

fun getGcd(
    a: Int,
    b: Int,
): Int {
    var x = a
    var y = b
    while (y != 0) {
        val temp = y
        y = x % y
        x = temp
    }
    return x
}
