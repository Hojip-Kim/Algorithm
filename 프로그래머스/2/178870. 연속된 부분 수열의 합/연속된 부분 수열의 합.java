import java.util.*;

class Node {
    private int startIdx;
    private int endIdx;

    public Node(int startIdx, int endIdx) {
        this.startIdx = startIdx;
        this.endIdx = endIdx;
    }

    public int getStartIdx() { return this.startIdx; }
    public int getEndIdx()   { return this.endIdx;   }
}

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        List<Node> nodeList = new ArrayList<>();

        int n = sequence.length;
        int startIdx = 0, endIdx = 0;
        int sum = sequence[0];

        while (startIdx < n) {
            if (sum < k) {
                // 더 이상 확장할 수 없으면 종료
                if (endIdx == n - 1) break;
                // 오른쪽 포인터 이동
                sum += sequence[++endIdx];
            }
            else if (sum > k) {
                // 왼쪽 포인터 이동
                sum -= sequence[startIdx++];
            }
            else { 
                nodeList.add(new Node(startIdx, endIdx));
                // 다음 구간 탐색을 위해 왼쪽 이동
                sum -= sequence[startIdx++];
            }
        }

        // 가장 짧고, 같으면 앞쪽인 구간 선택
        Node best = nodeList.get(0);
        for (Node node : nodeList) {
            int currLen = node.getEndIdx() - node.getStartIdx();
            int bestLen = best.getEndIdx() - best.getStartIdx();
            if (currLen < bestLen ||
               (currLen == bestLen && node.getStartIdx() < best.getStartIdx())) {
                best = node;
            }
        }

        answer[0] = best.getStartIdx();
        answer[1] = best.getEndIdx();
        return answer;
    }
}
