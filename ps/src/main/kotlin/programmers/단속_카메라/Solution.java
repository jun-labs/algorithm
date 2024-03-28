package programmers.단속_카메라;

import static java.lang.Integer.MIN_VALUE;
import static java.util.Comparator.comparingInt;

import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, comparingInt(route -> route[1]));
        int camera = 0;
        int min = MIN_VALUE;

        for (int[] route : routes) {
            if (min < route[0]) {
                camera++;
                min = route[1];
            }
        }
        return camera;
    }
}
