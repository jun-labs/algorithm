package programmers.디스크_컨트롤러

import java.util.*

class Solution {
    private val queue = PriorityQueue<Job>(compareBy { it.start })
    private val waitingQueue = PriorityQueue<Job>(compareBy { it.end })

    fun solution(jobs: Array<IntArray>): Int {
        for (job in jobs) {
            val start = job[0]
            val end = job[1]
            queue.offer(Job(start, end))
        }

        var currentTime = 0
        var totalWaitTime = 0
        while (queue.isNotEmpty() || waitingQueue.isNotEmpty()) {
            while (queue.isNotEmpty() && queue.peek().start <= currentTime) {
                waitingQueue.add(queue.poll())
            }

            if (waitingQueue.isNotEmpty()) {
                val job = waitingQueue.poll()
                if (currentTime < job.start) {
                    currentTime = job.start
                }
                currentTime += job.end
                totalWaitTime += currentTime - job.start
            } else if (queue.isNotEmpty()) {
                currentTime = queue.peek().start
            }
        }
        return totalWaitTime / jobs.size
    }
}

data class Job(val start: Int, val end: Int)
