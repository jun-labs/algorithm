package boj.boj_10989

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()

    val counts = IntArray(10_001)

    for (idx in 0 until n) {
        val number = br.readLine().toInt()
        counts[number]++
    }

    for (idx in counts.indices) {
        for (j in 0 until counts[idx]) {
            bw.write("$idx\n")
        }
    }

    bw.flush()
    bw.close()
    br.close()
}
