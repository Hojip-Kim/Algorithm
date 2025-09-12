import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] cost = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) cost[i] = Integer.parseInt(st.nextToken());

            List<Integer>[] g = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();
            int[] indeg = new int[N + 1];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                g[X].add(Y);     // X 먼저 → Y
                indeg[Y]++;
            }

            int W = Integer.parseInt(br.readLine().trim());

            // 위상정렬 + DP
            int[] dp = new int[N + 1]; // i번 건물 완성까지의 최소 시간(=최장 선행시간 + cost[i])
            ArrayDeque<Integer> q = new ArrayDeque<>();

            for (int i = 1; i <= N; i++) {
                if (indeg[i] == 0) {
                    dp[i] = cost[i];
                    q.add(i);
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int nxt : g[cur]) {
                    // nxt를 짓기 전까지 필요한 선행 최대 시간 갱신
                    if (dp[nxt] < dp[cur] + cost[nxt]) {
                        dp[nxt] = dp[cur] + cost[nxt];
                    }
                    if (--indeg[nxt] == 0) q.add(nxt);
                }
            }

            out.append(dp[W]).append('\n');
        }

        System.out.print(out.toString());
    }
}
