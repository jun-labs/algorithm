package programmers.단속_카메라;

import static java.util.Comparator.*;

import java.util.*;

// 정렬 기준 예시: [[2,8], [3,5], [6,7]]
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, comparingInt(route -> route[1]));

        int camera = 0;
        int min = -100_000;
        for (int[] route : routes) {
            if (min < route[0]) {
                camera++;
                min = route[1];
            }
        }
        return camera;
    }
}
