import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> countByType = new HashMap<>();

        for (String[] cloth : clothes) {
            String type = cloth[1];
            countByType.put(type, countByType.getOrDefault(type, 0) + 1);
        }

        int ways = 1;
        for (int c : countByType.values()) {
            ways *= (c + 1); // 안 입음(1) 포함
        }
        return ways - 1; // 전부 안 입는 경우 제외
    }
}
