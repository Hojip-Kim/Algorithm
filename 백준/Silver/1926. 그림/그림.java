import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
public class Main {

    static int[][] arr;

    static int[][] direction = {{1, 0}, {0 , 1}, {-1, 0}, {0, -1}};

    static int n, m;

    static boolean[][] isVisited;

    static int maxSize = 0;
    static int drawNum = 0;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n][m];
            isVisited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if((isVisited[i][j] == false) && (arr[i][j] == 1)) {
                        drawNum++;
                        bfs(j, i);
                    }
                }
            }

            bw.write(drawNum + "\n");
            bw.write(maxSize + "\n");
            bw.flush();
            bw.close();

        }

        public static void bfs(int x, int y){
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(x,y));
            int size = 1;
            isVisited[y][x] = true;
            while(!q.isEmpty()){
                Node cur = q.poll();
                int nx = cur.getX();
                int ny = cur.getY();
                for(int[] d : direction){
                    int dx = nx + d[0];
                    int dy = ny + d[1];
                    if( (dx >= 0 && dy >= 0 && dx < m && dy < n ) && (!isVisited[dy][dx]) && (arr[dy][dx] == 1)){
                        isVisited[dy][dx] = true;
                        q.add(new Node(dx,dy));
                        size++;
                    }
                }
                maxSize = Math.max(maxSize,size);
            }
        }
    }

