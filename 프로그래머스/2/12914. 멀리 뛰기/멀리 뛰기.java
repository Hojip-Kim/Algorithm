class Solution {
    private static int[] dp;
    // dp문제
    public long solution(int n) {
        long answer = 0;
        // 한 번에 1칸 또는 2칸 1 1 1 1 1 1
        //n : 6 => 13, n : 5 => 8, n : 4 => 5, n : 3 => 3, n : 2 => 2, n : 1 : 1 
        
        if (n <= 2) {
            return n;
        }
        
        dp = new int[n+1];
        
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i < n+1; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        return dp[n];
    }
}