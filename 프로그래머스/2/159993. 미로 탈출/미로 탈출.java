import java.util.*;

class Solution {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }
    }

    private static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static boolean[][] isVisited;
    private static String[] map;
    private static boolean isArrived = false;
    private static Node leverNode;

    public int solution(String[] maps) {
        int answer = 0;

        Node startNode = null;
        int startX = 0;
        int startY = 0;

        for(String map : maps) {
            if(map.contains("S")){
                startNode = new Node(map.indexOf("S"), startY);
            }
            startY++;
        }

        if(startNode == null){
            return -1;
        }


        isVisited = new boolean[maps.length][maps[0].length()];

        map = maps;

        // 레버까지의 최소거리를 찾는다.
        answer += bfs(startNode.getX(), startNode.getY(), 'L');

        // 레버의 좌표를 찾는다.
        Node lever = leverNode;

        // 다녀온 흔적을 초기화한다.
        isVisited = new boolean[maps.length][maps[0].length()];

        // 레버를 찾았는지 확인한다
        // 못 찾았으면 -1 리턴
        boolean isLeverFound = isArrived;
        if(!isLeverFound){
            return -1;
        }

        // isArrived를 초기화한다.
        isArrived = false;


        // 레버에서 도착지점까지의 최소거리를 찾는다.
        answer += bfs(lever.getX(), lever.getY(), 'E');

        // 도착지점에 도착했는지 확인한다.
        boolean isArrivedToDestination = isArrived;
        if(!isArrivedToDestination){
            return -1;
        }

        return answer;
    }

    private static int bfs(int startX, int startY, char target) {
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(startX, startY));
        isVisited[startY][startX] = true;
        int[][] distanceMap = new int[map.length][map[0].length()];
        distanceMap[startY][startX] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int curX = node.getX();
            int curY = node.getY();

            if(map[curY].charAt(curX) == target){
                leverNode = node;
                isArrived = true;
                return distanceMap[curY][curX];
            }

            for(int i = 0; i < direction.length; i++){
                int nextX = curX + direction[i][0];
                int nextY = curY + direction[i][1];

                if(!isCorrectRoute(nextX, nextY, map)){
                    continue;
                }

                if(!isVisited[nextY][nextX] && map[nextY].charAt(nextX) != 'X'){
                    distanceMap[nextY][nextX] = distanceMap[curY][curX] + 1;
                    isVisited[nextY][nextX] = true;
                    queue.add(new Node(nextX, nextY));
                }
            }
        }
        return 0;
    }

    public static boolean isCorrectRoute(int x, int y, String[] map) {
        return x >= 0 && x < map[0].length() && y >= 0 && y < map.length;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int answer = solution.solution(new String[]{"SOOOO", "OOOLO", "OOOOE", "OOOOO", "OOOOO"});
//
//        System.out.println(answer);
//    }
}