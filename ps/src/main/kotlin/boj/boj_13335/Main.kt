package boj.boj_13335

import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, w, L) = readln().split(" ").map { it.toInt() }
    val weights = readln().split(" ")
        .map { it.toInt() }
        .toIntArray()

    val trucksOnTheBridge = LinkedList<Truck>()
    val waitingTrucks: Queue<Truck> = LinkedList()
    for ((idx, weight) in weights.withIndex()) {
        waitingTrucks.add(Truck(idx, weight))
    }

    var answer = 0
    var totalWeight = 0
    while (trucksOnTheBridge.isNotEmpty() || waitingTrucks.isNotEmpty()) {
        answer++
        if (trucksOnTheBridge.isNotEmpty()) {
            val trucksCrossedBridge = mutableListOf<Truck>()
            for (truck in trucksOnTheBridge) {
                truck.time += 1
                if (truck.time >= w) {
                    trucksCrossedBridge.add(truck)
                    totalWeight -= truck.weight
                }
            }
            trucksOnTheBridge.removeAll(trucksCrossedBridge.toSet())
        }

        if (waitingTrucks.peek() != null) {
            val waitingTruck = waitingTrucks.peek()
            if (waitingTruck.weight + totalWeight <= L) {
                trucksOnTheBridge.add(waitingTrucks.poll())
                totalWeight += waitingTruck.weight
            }
        }
    }
    println(answer)
}

data class Truck(
    val idx: Int,
    val weight: Int,
) {
    var time = 0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Truck
        return idx == other.idx
    }

    override fun hashCode(): Int {
        return idx
    }
}
