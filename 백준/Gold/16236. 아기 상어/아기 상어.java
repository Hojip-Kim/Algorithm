import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int sr, sc;          // shark row, col
    static int size = 2;        // initial size
    static int eaten = 0;       // eaten count toward next size
    static int time = 0;        // total time (answer)
    static final int[] dr = {-1, 0, 0, 1}; // 상, 좌, 우, 하 (거리 동일시 행/열 우선 tie-break에 유리: 상→좌 우선 탐색)
    static final int[] dc = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) { // 아기 상어 시작점
                    sr = i; sc = j;
                    map[i][j] = 0;   // 빈 칸으로 바꿔둔다
                }
            }
        }

        while (true) {
            Target t = bfsFindTarget();
            if (t == null) break;   // 더 이상 먹을 물고기 없음

            // 이동 & 섭취
            time += t.dist;
            sr = t.r; sc = t.c;
            map[sr][sc] = 0;
            eaten++;
            if (eaten == size) {
                size++;
                eaten = 0;
            }
        }

        System.out.println(time);
    }

    // 가장 가까운 먹이 하나를 찾는다. 없다면 null
    static Target bfsFindTarget() {
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], -1);

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        dist[sr][sc] = 0;

        int bestDist = Integer.MAX_VALUE;
        int bestR = -1, bestC = -1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            int d = dist[r][c];
            // 이미 발견한 최단 먹이 거리보다 멀면 더 볼 필요 없음
            if (d > bestDist) continue;

            // 먹을 수 있는 물고기(1~6)이고, 상어 크기보다 작아야 함
            if (map[r][c] > 0 && map[r][c] < size) {
                // 후보 갱신: 거리 최소, 거리 같으면 행 최소, 그래도 같으면 열 최소
                if (d < bestDist ||
                    (d == bestDist && (r < bestR ||
                    (r == bestR && c < bestC)))) {
                    bestDist = d;
                    bestR = r; bestC = c;
                }
                // 같은 거리의 다른 후보가 있을 수 있으므로 계속 탐색하되,
                // 거리가 더 커지는 레벨은 위의 if (d > bestDist) 에 걸려 스킵됨.
            }

            // 인접 칸으로 BFS 확장
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (dist[nr][nc] != -1) continue;
                // 이동 가능 조건: 상어 크기보다 작거나 같은 칸만 통과 가능(0=빈칸 포함)
                if (map[nr][nc] <= size) {
                    dist[nr][nc] = d + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        if (bestR == -1) return null; // 못 찾음
        return new Target(bestR, bestC, bestDist);
    }

    static class Target {
        int r, c, dist;
        Target(int r, int c, int dist) {
            this.r = r; this.c = c; this.dist = dist;
        }
    }
}
