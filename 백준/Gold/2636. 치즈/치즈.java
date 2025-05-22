import java.io.*;
import java.util.*;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Main {


    private static Set<Node> meltList = new HashSet<Node>();
    private static boolean[][] isVisited;
    private static int[][] prevCheeseMap;
    private static int[][] cheeseMap;
    private static int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] widthHeight = br.readLine().split(" ");
        int height = Integer.parseInt(widthHeight[0]);
        int width = Integer.parseInt(widthHeight[1]);

        isVisited = new boolean[height][width];
        cheeseMap = new int[height][width];
        prevCheeseMap = new int[height][width];

        for(int i = 0; i < height; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < width; j++){
                cheeseMap[i][j] = Integer.parseInt(line[j]);
            }
        }

        int hour = 0;
        while(true) {
            hour++;

            Node initialNode = findAreaOfAir();
            bfs(initialNode.getX(), initialNode.getY());
            for(int i = 0; i < height; i++){
                prevCheeseMap[i] = cheeseMap[i].clone();
            }
            meltCheese();

            isVisited = new boolean[height][width];

            if(isAllMeltCheese()){
                int area = findPrevCheeseArea();
                bw.append(hour + "\n" + area + "\n");
                break;
            }
        }


        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int nodeX = node.getX();
            int nodeY = node.getY();

            for(int[] dirction : directions){
                int newX = nodeX + dirction[0];
                int newY = nodeY + dirction[1];

                if(isCorrectBoundary(newY, newX) && !isVisited[newY][newX]){
                    isVisited[newY][newX] = true;
                    // 공기 구역이면
                    if(cheeseMap[newY][newX] == 0){
                        // bfs 그대로
                        queue.add(new Node(newX, newY));
                        // 치즈구역이면
                    }else {
                        // 녹여야할 구간으로 지정
                        meltList.add(new Node(newX, newY));
                    }
                }

            }
        }
    }

    private static boolean isCorrectBoundary(int y, int x) {
        return 0 <= y && y < cheeseMap.length && 0 <= x && x < cheeseMap[0].length;
    }

    private static void meltCheese(){
        for(Node node : meltList){
            cheeseMap[node.getY()][node.getX()] = 0;
        }
        meltList.clear();
    }

    private static boolean isAllMeltCheese(){
        for(int[] line : cheeseMap){
            for(int i = 0; i < line.length; i++){
                if(line[i] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    private static Node findAreaOfAir(){
        for(int y = 0; y < cheeseMap.length; y++){
            for(int x = 0; x < cheeseMap[0].length; x++){
                if(cheeseMap[y][x] == 0){
                    return new Node(x, y);
                }
            }
        }
        return null;
    }

    private static int findPrevCheeseArea() {
        int count = 0;
        for(int y = 0; y < prevCheeseMap.length; y++){
            for(int x = 0; x < prevCheeseMap[0].length; x++){
                if(prevCheeseMap[y][x] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}