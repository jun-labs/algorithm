package boj.boj_2386

fun main() {
    while (true) {
        val input = readln()
        if (input == "#") break

        val target = input.first()
        val sentence = input.substring(2)

        val count = sentence.count {
            it.equals(target, ignoreCase = true)
        }
        println("$target $count")
    }
}
