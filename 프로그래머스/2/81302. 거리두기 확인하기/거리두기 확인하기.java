import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = checkRoom(places[i]) ? 1 : 0;
        }
        return answer;
    }

    private boolean checkRoom(String[] place) {
        char[][] g = new char[5][5];
        for (int r = 0; r < 5; r++) g[r] = place[r].toCharArray();

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (g[r][c] == 'P' && !isSafe(r, c, g)) return false;
            }
        }
        return true;
    }

    // 시작 'P'에서 벽('X')은 지나지 않고 깊이 2까지 BFS.
    // 깊이 1~2에서 다른 'P'를 만나면 규칙 위반.
    private boolean isSafe(int sr, int sc, char[][] g) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        boolean[][] vis = new boolean[5][5];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc, 0});
        vis[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], d = cur[2];

            if (d >= 1 && d <= 2 && g[r][c] == 'P') return false; // 위반
            if (d == 2) continue; // 더 멀리는 보지 않음

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                if (vis[nr][nc] || g[nr][nc] == 'X') continue; // 벽은 통과 금지
                vis[nr][nc] = true;
                q.offer(new int[]{nr, nc, d + 1});
            }
        }
        return true;
    }
}
