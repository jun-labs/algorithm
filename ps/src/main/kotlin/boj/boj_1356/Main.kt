package boj.boj_1356

fun main() {
    val n = readln()
    var answer = "NO"
    val len = n.length

    if (len > 1) {
        for (number in 1 until len) {
            var firstResult = 1
            var secondResult = 1
            for (firstIdx in 0 until number) {
                firstResult *= (n[firstIdx] - '0')
            }
            for (secondIdx in number until len) {
                secondResult *= (n[secondIdx] - '0')
            }
            if (firstResult == secondResult) {
                answer = "YES"
                break
            }
        }
    }
    println(answer)
}
