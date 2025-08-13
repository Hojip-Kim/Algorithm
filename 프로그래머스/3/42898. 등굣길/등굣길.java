class Solution {
    
    private static int[][] dp;
    private static boolean[][] poolMap;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        dp = new int[n+1][m+1];
        
        dp[1][1] = 1;
        poolMap = new boolean[n+1][m+1];
        for(int[] puddle : puddles){
            poolMap[puddle[1]][puddle[0]] = true;
        }
        
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {
                if (i == 1 && j == 1) continue;
                if(!poolMap[i][j]){
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000007;
                }
            }
        }
        
        return dp[n][m];
    }
}