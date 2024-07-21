package programmers.데이터_분석;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private static final Map<String, Integer> extMap = new HashMap<>();

    static {
        extMap.put("code", 0);
        extMap.put("date", 1);
        extMap.put("maximum", 2);
        extMap.put("remain", 3);
    }

    public int[][] solution(
        int[][] data,
        String ext,
        int val_ext,
        String sort_by
    ) {
        int dataKind = extMap.get(ext);
        List<int[]> lst = new ArrayList<>();
        int orderBy = extMap.get(sort_by);
        for (int[] array : data) {
            if (array[dataKind] < val_ext) {
                lst.add(array);
            }
        }
        lst.sort(Comparator.comparingInt(array -> array[orderBy]));
        int[][] answer = new int[lst.size()][];
        for (int index = 0; index < lst.size(); index++) {
            answer[index] = lst.get(index);
        }
        return answer;
    }
}
