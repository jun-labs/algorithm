package programmers.충돌_위험_찾기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

// https://acg6138.tistory.com/ 참조
class Solution {

    private int r;
    private int c;
    private static final Map<Integer, Point> pointMap = new HashMap<>();

    public int solution(
        int[][] points,
        int[][] routes
    ) {
        init(points);

        int answer = 0;
        int longestDistance = 0;
        List<List<Point>> shortestRoutes = new ArrayList<>();
        for (int[] route : routes) {
            List<Point> findRoutes = findRoute(route);
            shortestRoutes.add(findRoutes);
            longestDistance = Math.max(longestDistance, findRoutes.size());
        }
        answer = findStrikeCount(shortestRoutes, longestDistance);
        return answer;
    }

    public void init(int[][] points) {
        for (int index = 0; index < points.length; index++) {
            pointMap.put(index + 1, new Point(points[index][1], points[index][0]));
        }
        int r = 0;
        int c = 0;
        for (int[] point : points) {
            if (point[0] > r) {
                r = point[0];
            }
            if (point[1] > c) {
                c = point[1];
            }
        }
        this.r = r;
        this.c = c;
    }

    public List<Point> findRoute(int[] points) {
        List<Point> shortestRoute = new ArrayList<>();
        for (int index = 1; index < points.length; index++) {
            Point start = pointMap.get(points[index - 1]);
            Point end = pointMap.get(points[index]);
            int x = start.x;
            int y = start.y;
            if (shortestRoute.isEmpty()) {
                shortestRoute.add(new Point(x, y));
            }

            while (y != end.y) {
                y += (y > end.y) ? -1 : 1;
                shortestRoute.add(new Point(x, y));
            }

            while (x != end.x) {
                x += (x > end.x) ? -1 : 1;
                shortestRoute.add(new Point(x, y));
            }
        }
        return shortestRoute;
    }

    public int findStrikeCount(
        List<List<Point>> shortestRoutes,
        int longestDistance
    ) {
        int totalCount = 0;
        for (int index = 0; index < longestDistance; index++) {
            Map<Point, Integer> countMap = new HashMap<>();
            for (List<Point> shortestRoute : shortestRoutes) {
                Point point = (shortestRoute.size() > index) ? shortestRoute.get(index) : null;
                if (point != null) {
                    int count = countMap.getOrDefault(point, 0);
                    countMap.put(point, count);
                }
            }
            for (Integer count : countMap.values()) {
                if (count > 1) {
                    totalCount += 1;
                }
            }
        }
        return totalCount;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
