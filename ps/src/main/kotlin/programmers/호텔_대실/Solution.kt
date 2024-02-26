package programmers.호텔_대실

import java.util.PriorityQueue
import java.util.Queue

class Solution {
    private val queue: Queue<Int> = PriorityQueue()

    fun solution(book_time: Array<Array<String>>): Int {
        val rooms = ArrayList<Room>()
        for (eachRoom in book_time) {
            rooms.add(Room(convertToInt(eachRoom[0], false), convertToInt(eachRoom[1])))
        }
        rooms.sort()

        for (eachRoom in rooms) {
            if (queue.isNotEmpty() && queue.peek() <= eachRoom.start) {
                queue.poll()
            }
            queue.add(eachRoom.end)
        }
        return queue.size
    }

    private fun convertToInt(
        time: String,
        addCleaningTime: Boolean = true
    ): Int {
        val timeArray = time.split(":")
        val hour = timeArray[0].toInt()
        var minutes = timeArray[1].toInt()

        if (addCleaningTime) {
            minutes += 10
        }

        if (minutes >= 60) {
            return (hour + 1) * 60 + (minutes - 60)
        }
        return hour * 60 + minutes
    }
}

data class Room(
    var start: Int,
    var end: Int
) : Comparable<Room> {
    override fun compareTo(other: Room): Int = if (this.start != other.start) {
        this.start - other.start
    } else {
        this.end - other.end
    }
}

fun main() {
    val bookTime = arrayOf(
        arrayOf("15:00", "17:00"),
        arrayOf("16:40", "18:20"),
        arrayOf("14:20", "15:20"),
        arrayOf("14:10", "19:20"),
        arrayOf("18:20", "21:20")
    )
    val solution = Solution()
    solution.solution(bookTime)
}
