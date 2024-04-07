package programmers.다리를_지나는_트럭

import java.util.LinkedList
import java.util.Queue

class Solution {
    private val waitingTrucks: Queue<Truck> = LinkedList()
    private val onRoadTrucks: MutableList<Truck> = ArrayList()

    fun solution(
        bridgeLength: Int,
        weight: Int,
        truckWeights: IntArray
    ): Int {
        var time = 0
        var totalWeight = 0
        for ((idx, truckWeight) in truckWeights.withIndex()) {
            waitingTrucks.add(Truck(idx, 0, truckWeight))
        }

        while (waitingTrucks.isNotEmpty() || onRoadTrucks.isNotEmpty()) {
            time++
            val crossedTrucks = mutableListOf<Truck>()
            for (truck in onRoadTrucks) {
                truck.time++
                if (truck.time >= bridgeLength) {
                    crossedTrucks.add(truck)
                    totalWeight -= truck.weight
                }
            }
            onRoadTrucks.removeAll(crossedTrucks)

            val nextTruck = waitingTrucks.peek()
            if (canCrossBridge(weight, totalWeight)) {
                onRoadTrucks.add(waitingTrucks.poll())
                totalWeight += nextTruck.weight
            }
        }
        return time
    }

    private fun canCrossBridge(
        weight: Int,
        totalTruckWeight: Int
    ): Boolean {
        return waitingTrucks.isNotEmpty() &&
                totalTruckWeight + (waitingTrucks.peek()?.weight ?: 0) <= weight
    }
}

internal class Truck(
    val id: Int,
    var time: Int,
    val weight: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Truck) return false
        if (id != other.id) return false
        return true
    }

    override fun hashCode(): Int {
        return id
    }
}

fun main() {
    val solution = Solution()
    val bridgeLength = 2
    val weight = 10
    val truckWeights = intArrayOf(7, 4, 5, 6)
    println(solution.solution(bridgeLength, weight, truckWeights))
}
