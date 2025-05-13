import java.io.*;
        import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static char[][] garbageMap;

    private static int maxGarbageSize = -1;

    private static int cntSize = 0;

    private static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        garbageMap = new char[N][M];
        isVisited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            Arrays.fill(garbageMap[i], '.');
        }

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            // x
            int r = Integer.parseInt(st.nextToken());
            // y
            int c = Integer.parseInt(st.nextToken());
            garbageMap[r-1][c-1] = '#';
        }


        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!isVisited[i][j] && garbageMap[i][j] == '#'){
                    cntSize++;
                    isVisited[i][j] = true;
                    dfs(j, i);
                    maxGarbageSize = Math.max(maxGarbageSize, cntSize);
                    cntSize = 0;
                }
            }
        }

        bw.write(maxGarbageSize + "\n");
        bw.flush();
        br.close();
    }

    private static void dfs(int x, int y){
        for(int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if(isPossibleRoad(newX, newY) && !isVisited[newY][newX] && isGarbage(newX, newY) ){
                isVisited[newY][newX] = true;
                cntSize++;
                dfs(newX, newY);
            }
        }
    }

    private static boolean isPossibleRoad(int x, int y){
        return 0 <= x && x < garbageMap[0].length && 0 <= y && y < garbageMap.length;
    }
    private static boolean isGarbage(int x, int y){
        return garbageMap[y][x] =='#';
    }
}
