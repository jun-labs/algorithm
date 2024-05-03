package boj.boj_2110

fun main() {
    val (n, c) = readln().split(" ")
        .map { it.toInt() }

    val houses = mutableListOf<Int>()
    for (idx in 0 until n) {
        val house = readln().toInt()
        houses.add(house)
    }

    houses.sort()

    var start = 0
    var end = houses.last() - houses.first()
    var answer = 0
    while (start <= end) {
        val mid = (start + end) / 2
        var count = 1
        var house = houses[0]

        for (idx in 1 until houses.size) {
            if (house + mid <= houses[idx]) {
                count++
                house = houses[idx]
            }
        }

        if (count >= c) {
            start = mid + 1
            answer = mid
        } else {
            end = mid - 1
        }
    }
    println(answer)
}
