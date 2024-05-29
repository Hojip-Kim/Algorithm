import java.io.*;
import java.util.*;

class IceBerg {
    int x;
    int y;

    IceBerg(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int years = 0;
        while (true) {
            int count = countLand(map);
            if (count >= 2) {
                break;
            }
            if (count == 0) {
                years = 0;
                break;
            }
            melt(map);
            years++;
        }
        
        bw.write(years + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int countLand(int[][] graphs) {
        isVisited = new boolean[N][M];
        int cnt = 0;
        for (int i = 0; i < graphs.length; i++) {
            for (int j = 0; j < graphs[i].length; j++) {
                if(graphs[i][j] != 0 && !isVisited[i][j]) {
                    DFS(graphs, j, i, isVisited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void DFS(int[][] graphs, int x, int y, boolean[][] isVisited) {
        isVisited[y][x] = true;
        int nx, ny;

        for (int i = 0; i < directions.length; i++) {
            nx = x + directions[i][0];
            ny = y + directions[i][1];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (graphs[ny][nx] != 0 && !isVisited[ny][nx]) {
                    DFS(graphs, nx, ny, isVisited);
                }
            }
        }
    }

    public static void melt(int[][] graphs) {
        int[][] tempMap = new int[N][M];
        boolean[][] isSea = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graphs[i][j] == 0) {
                    isSea[i][j] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graphs[i][j] > 0) {
                    int seaCount = 0;
                    for (int[] direction : directions) {
                        int nx = j + direction[0];
                        int ny = i + direction[1];

                        if (nx >= 0 && nx < M && ny >= 0 && ny < N && isSea[ny][nx]) {
                            seaCount++;
                        }
                    }
                    tempMap[i][j] = Math.max(0, graphs[i][j] - seaCount);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graphs[i][j] = tempMap[i][j];
            }
        }
    }
}
