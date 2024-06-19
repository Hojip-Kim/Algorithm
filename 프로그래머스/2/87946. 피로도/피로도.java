class Solution {

    private static int answer;
    private boolean[] isVisited;

    public int solution(int k, int[][] dungeons) {

        isVisited = new boolean[dungeons.length];

        DFS(0, dungeons, k);

        return answer;
    }

    public void DFS(int depth, int[][] dungeons, int k){

        for (int i = 0; i < dungeons.length; i++) {
            if(!isVisited[i] && dungeons[i][0] <= k){
                isVisited[i] = true;
                DFS(depth + 1 , dungeons, k-dungeons[i][1]);
                isVisited[i] = false;
            }
        }
        answer = Math.max(answer, depth);

    }

}