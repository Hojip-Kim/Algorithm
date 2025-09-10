import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5; // 캐시가 없으면 전부 miss

        // accessOrder=true 로 최신 접근 순서 유지(LRU)
        LinkedHashMap<String, Boolean> cache = new LinkedHashMap<>(cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
                return size() > cacheSize; // 용량 초과 시 가장 오래된 항목 제거
            }
        };

        int time = 0;
        for (String city : cities) {
            String key = city.toLowerCase();

            if (cache.containsKey(key)) {
                cache.get(key); // 접근하여 순서를 최신으로 갱신
                time += 1;
            } else {
                cache.put(key, Boolean.TRUE);
                time += 5;
            }
        }
        return time;
    }
}
