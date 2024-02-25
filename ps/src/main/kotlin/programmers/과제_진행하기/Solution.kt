package programmers.과제_진행하기

import java.util.Stack

class Solution {
    fun solution(plans: Array<Array<String>>): Array<String> {
        val tasks = plans.map { Task(it) }
            .sortedBy { it.start }

        val stoppedPlans = Stack<Task>()
        val answer = mutableListOf<String>()
        for (index in 0 until tasks.size - 1) {
            val currentPlan = tasks[index]
            val nextPlan = tasks[index + 1]

            if (currentPlan.endTime > nextPlan.start) {
                val playTime = nextPlan.start - currentPlan.start
                currentPlan.playTime -= playTime
                stoppedPlans.push(currentPlan)
                continue
            }
            answer.add(currentPlan.name)

            var restTime = nextPlan.start - currentPlan.endTime
            while (restTime > 0 && stoppedPlans.isNotEmpty()) {
                val stoppedPlan = stoppedPlans.peek()
                val remainingPlayTime = stoppedPlan.playTime - restTime

                if (remainingPlayTime > 0) {
                    stoppedPlan.playTime = remainingPlayTime
                    break
                } else {
                    restTime -= stoppedPlan.playTime
                    answer.add(stoppedPlans.pop().name)
                }
            }
        }

        answer.add(tasks.last().name)
        while (stoppedPlans.isNotEmpty()) {
            answer.add(stoppedPlans.pop().name)
        }
        return answer.toTypedArray()
    }
}

class Task(plan: Array<String>) {
    val name: String = plan[0]
    val start: Int
    var playTime: Int

    init {
        val time = plan[1].split(":")
            .map { it.toInt() }
        this.start = time[0] * 60 + time[1]
        this.playTime = plan[2].toInt()
    }

    val endTime: Int
        get() = start + playTime
}

fun main() {
    val plans = arrayOf(
        arrayOf("korean", "11:40", "30"),
        arrayOf("english", "12:10", "20"),
        arrayOf("math", "12:30", "40")
    )
    val plans2 = arrayOf(
        arrayOf("science", "12:40", "50"),
        arrayOf("music", "12:20", "40"),
        arrayOf("history", "14:00", "30"),
        arrayOf("computer", "12:30", "100")
    )

    val solution = Solution()
    solution.solution(plans2)
}
