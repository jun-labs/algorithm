package programmers.붕대_감기;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private final Map<Integer, Integer> map = new HashMap<>();

    public int solution(
        int[] bandage,
        int health,
        int[][] attacks
    ) {
        int max = 0;
        for (int[] attack : attacks) {
            int key = attack[0];
            int value = attack[1];
            max = Math.max(max, key);
            map.put(key, value);
        }

        int time = 0;
        int maxHealth = health;
        int sequence = 0;
        while (time <= max) {
            System.out.println(health);
            Integer attack = map.getOrDefault(time, 0);
            if (attack == 0) {
                health += bandage[1];
                if (health > maxHealth) {
                    health = maxHealth;
                }
                sequence++;
                if (sequence == bandage[0]) {
                    health += bandage[2];
                    if (health > maxHealth) {
                        health = maxHealth;
                    }
                    sequence = 0;
                    time++;
                }
            } else {
                sequence = 0;
                health -= attack;
                if (health <= 0) {
                    return -1;
                }
            }
            time++;
        }
        return health;
    }
}

/**
 * // 더 빠른 풀이
 * class Solution {
 *     private final Map<Integer, Integer> map = new HashMap<>();
 *
 *     public int solution(
 *         int[] bandage,
 *         int health,
 *         int[][] attacks
 *     ) {
 *         int max = 0;
 *         for (int[] attack : attacks) {
 *             int key = attack[0];
 *             int value = attack[1];
 *             max = Math.max(max, key);
 *             map.put(key, value);
 *         }
 *
 *         int time = 0;
 *         int maxHealth = health;
 *         int sequence = 0;
 *         while (time <= max) {
 *             Integer attack = map.getOrDefault(time, 0);
 *             if (attack == 0) {
 *                 health += bandage[1];
 *                 if (health > maxHealth) {
 *                     health = maxHealth;
 *                 }
 *                 sequence++;
 *                 if (sequence == bandage[0]) {
 *                     health += bandage[2];
 *                     if (health > maxHealth) {
 *                         health = maxHealth;
 *                     }
 *                     sequence = 0;
 *                     time++;
 *                 }
 *             } else {
 *                 sequence = 0;
 *                 health -= attack;
 *                 if (health <= 0) {
 *                     return -1;
 *                 }
 *             }
 *             time++;
 *         }
 *         return health;
 *     }
 * }
 * */
