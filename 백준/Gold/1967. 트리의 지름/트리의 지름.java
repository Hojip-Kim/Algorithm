import java.io.*;
import java.util.ArrayList;

class Node {
    private int weight;
    private int childNode;

    public Node(int weight, int childNode) {
        this.weight = weight;
        this.childNode = childNode;
    }
    

    public int getWeight() {
        return weight;
    }

    public int getChildNode() {
        return childNode;
    }
}

public class Main {
    private static ArrayList<Node>[] nodeMap;
    private static boolean[] isVisited;
    private static int maxDistance = 0;
    private static int farthestNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // (1 <= n <= 10,000)
        int n = Integer.parseInt(br.readLine());

        // 노드가 1개인 경우 지름은 0
        if (n == 1) {
            bw.write("0\n");
            bw.flush();
            bw.close();
            return;
        }

        nodeMap = new ArrayList[n+1];
        isVisited = new boolean[n+1];

        // 모든 노드에 대한 ArrayList 초기화
        for (int i = 1; i <= n; i++) {
            nodeMap[i] = new ArrayList<>();
        }

        // 트리 입력 (n-1개의 간선)
        for(int i = 0; i < n-1; i++) {
            String[] input = br.readLine().split(" ");
            int parent = Integer.parseInt(input[0]);
            int child = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            nodeMap[parent].add(new Node(weight, child));
            nodeMap[child].add(new Node(weight, parent));
        }

        isVisited[1] = true;
        dfs(1, 0);
        
        isVisited = new boolean[n+1];
        isVisited[farthestNode] = true;
        maxDistance = 0;
        dfs(farthestNode, 0);

        bw.write(maxDistance + "\n");
        bw.flush();
        bw.close();
    }
    
    private static void dfs(int nodeNum, int distance) {
        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = nodeNum;
        }

        ArrayList<Node> nodes = nodeMap[nodeNum];
        for (Node node : nodes) {
            int nextNode = node.getChildNode();
            if (!isVisited[nextNode]) {
                isVisited[nextNode] = true;
                dfs(nextNode, distance + node.getWeight());
                isVisited[nextNode] = false;
            }
        }
    }
}