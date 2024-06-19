package boj.boj_13335.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int n = line[0];
        int w = line[1];
        int l = line[2];

        int[] weights = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        Queue<Truck> waitingTrucks = new LinkedList<>();
        for (int weight : weights) {
            waitingTrucks.add(new Truck(0, weight));
        }

        int answer = 0;
        int totalWeight = 0;
        Queue<Truck> trucksOnTheBridge = new LinkedList<>();
        while (!trucksOnTheBridge.isEmpty() || !waitingTrucks.isEmpty()) {
            answer++;
            Queue<Truck> trucksCrossedBridge = new LinkedList<>();
            for (Truck truck : trucksOnTheBridge) {
                truck.time++;
                if (truck.time >= w) {
                    trucksCrossedBridge.add(truck);
                    totalWeight -= truck.weight;
                }
            }
            trucksOnTheBridge.removeAll(trucksCrossedBridge);

            if (moveable(waitingTrucks, totalWeight, l)) {
                Truck newTruck = waitingTrucks.poll();
                trucksOnTheBridge.add(newTruck);
                totalWeight += newTruck.weight;
            }
        }
        System.out.println(answer);
    }

    private static boolean moveable(
        Queue<Truck> waitingTrucks,
        int totalWeight,
        int l
    ) {
        return !waitingTrucks.isEmpty()
            && waitingTrucks.peek().weight + totalWeight <= l;
    }

    static class Truck {
        int time;
        int weight;

        public Truck(
            int time,
            int weight
        ) {
            this.time = time;
            this.weight = weight;
        }
    }
}
