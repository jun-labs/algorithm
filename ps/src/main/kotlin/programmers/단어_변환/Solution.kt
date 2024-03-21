package programmers.단어_변환

import java.util.*

class Solution {
    private lateinit var visited: Array<Boolean>
    private val queue = LinkedList<Word>()

    fun solution(
        begin: String,
        target: String,
        words: Array<String>
    ): Int {
        if (!words.contains(target)) {
            return 0
        }

        val length = words.size
        visited = Array(length) { false }
        queue.add(Word(begin, 0))

        var answer = 0
        while (queue.isNotEmpty()) {
            val word = queue.poll()
            if (word.equals(target)) {
                answer = word.count
                break
            }
            for (idx in 0 until length) {
                if (!visited[idx] && isDifferentOnlyOneCharacter(word, words[idx])) {
                    visited[idx] = true
                    queue.add(Word(words[idx], word.count + 1))
                }
            }
        }
        return answer
    }

    private fun isDifferentOnlyOneCharacter(
        wordA: Word,
        wordB: String
    ): Boolean {
        if (!wordA.hasSameLength(wordB)) {
            return false
        }
        var count = 0
        for (idx in wordA.indices) {
            if (wordA.value[idx] != wordB[idx]) {
                count++
            }
            if (count > 1) {
                return false
            }
        }
        return count == 1
    }
}

data class Word(
    val value: String,
    val count: Int
) {

    val length: Int
        get() = value.length

    val indices: IntRange
        get() = value.indices

    fun equals(word: String): Boolean {
        return value == word
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Word
        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    fun hasSameLength(wordB: String): Boolean {
        return value.length == wordB.length
    }
}
