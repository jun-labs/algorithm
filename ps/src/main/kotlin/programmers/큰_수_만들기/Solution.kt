package programmers.큰_수_만들기

class Solution {
    fun solution(
        number: String,
        k: Int
    ): String {
        val answer = mutableListOf<Char>()
        var count = k
        for (char in number) {
            while (count > 0 && answer.isNotEmpty() && answer.last() < char) {
                answer.removeAt(answer.size - 1)
                count--
            }
            answer.add(char)
        }

        while (count-- > 0) {
            answer.removeAt(answer.size - 1)
        }
        return answer.joinToString("")
    }
}
