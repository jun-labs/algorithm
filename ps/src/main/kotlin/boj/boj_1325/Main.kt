package boj.boj_1325

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var relationship: MutableList<MutableList<Int>>
lateinit var visit: BooleanArray
lateinit var counts: IntArray
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    var max = -1
    relationship = MutableList(n + 1) { mutableListOf() }
    visit = BooleanArray(n + 1)
    counts = IntArray(n + 1)

    repeat(m) {
        val (s, e) = br.readLine().split(" ")
            .map { it.toInt() }
        relationship[s].add(e)
    }

    for (node in 1..n) {
        visit.fill(false)
        visit[0] = true
        dfs(node, visit, counts)
    }

    for (idx in 1..n) {
        if (max < counts[idx]) {
            max = counts[idx]
        }
    }

    val sb = StringBuilder()
    for (idx in 1..n) {
        if (max == counts[idx]) {
            if (idx != n) {
                sb.append(idx)
                    .append(" ")
            } else {
                sb.append(idx)
            }
        }
    }
    println(sb)
}

fun dfs(
    node: Int,
    visit: BooleanArray,
    count: IntArray,
) {
    visit[node] = true

    for (next in relationship[node]) {
        if (!visit[next]) {
            count[next]++
            dfs(next, visit, count)
        }
    }
}
