import java.util.*;

class Solution {
    
    private static Map<String, int[]> directionMap = new HashMap<>();
    private static Set<String> visitSet = new HashSet<>();
    
    public int solution(String dirs) {
        // 테스트 케이스 간 섞임 방지
        directionMap.clear();
        visitSet.clear();

        int answer = 0;
        
        directionMap.put("U", new int[]{1, 0});
        directionMap.put("R", new int[]{0, 1});
        directionMap.put("L", new int[]{0, -1});
        directionMap.put("D", new int[]{-1, 0});
        
        String[] newDirs = dirs.split("");
        int[] cur = new int[]{5, 5}; // 시작지점 [5,5]
        
        for (String dir : newDirs) {
            int[] direction = directionMap.get(dir);
            if (direction == null){
                continue;
            }

            int nextX = cur[0] + direction[0];
            int nextY = cur[1] + direction[1];

            if (0 <= nextX && nextX <= 10 && 0 <= nextY && nextY <= 10) {
                int ax = cur[0], ay = cur[1];
                int bx = nextX, by = nextY;
                if (ax > bx || (ax == bx && ay > by)) {
                    int tx = ax, ty = ay;
                    ax = bx; ay = by;
                    bx = tx; by = ty;
                }
                String key = ax + "," + ay + "," + bx + "," + by;
                visitSet.add(key);

                cur = new int[]{nextX, nextY};
            }
        }

        return visitSet.size();
    }
}
