package programmers.다리를_지나는_트럭

import java.util.*

class Solution {
    private val waitingTrucks: Queue<Truck> = LinkedList()
    private val trucksOnRoad: MutableList<Truck> = ArrayList()

    fun solution(
        bridgeLength: Int,
        weight: Int,
        truckWeights: IntArray
    ): Int {
        var time = 0
        var totalWeightOnRoadTrucks = 0
        for ((id, truckWeight) in truckWeights.withIndex()) {
            waitingTrucks.add(Truck(id, 0, truckWeight))
        }

        while (waitingTrucks.isNotEmpty() || trucksOnRoad.isNotEmpty()) {
            time++
            val trucksCrossedBridge = mutableListOf<Truck>()
            for (onRoadTruck in trucksOnRoad) {
                onRoadTruck.time++
                if (onRoadTruck.time >= bridgeLength) {
                    trucksCrossedBridge.add(onRoadTruck)
                    totalWeightOnRoadTrucks -= onRoadTruck.weight
                }
            }
            trucksOnRoad.removeAll(trucksCrossedBridge)

            if (canCrossBridge(weight, totalWeightOnRoadTrucks)) {
                val truck = waitingTrucks.poll()
                totalWeightOnRoadTrucks += truck.weight
                trucksOnRoad.add(truck)
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
