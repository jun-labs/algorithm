package programmers.K번째수

class Solution {
    fun solution(
        array: IntArray,
        commands: Array<IntArray>
    ): IntArray {
        val answer = mutableListOf<Int>()
        for (command in commands) {
            val i = command[0] - 1
            val j = command[1] - 1
            val k = command[2] - 1

            val slicedArray = array.slice(i..j).sorted()
            answer.add(slicedArray[k])
        }
        return answer.toIntArray()
    }
}

fun main() {
    val intArray = intArrayOf(1, 5, 2, 6, 3, 7, 4)
    val command: Array<IntArray> = arrayOf(
        intArrayOf(2, 5, 3),
        intArrayOf(4, 4, 1),
        intArrayOf(1, 7, 3)
    )

    val solution = Solution()
    solution.solution(intArray, command)
}
