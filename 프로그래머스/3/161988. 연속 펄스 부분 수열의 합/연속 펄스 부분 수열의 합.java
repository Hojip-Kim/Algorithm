class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int sl = sequence.length;

        long dp[][] = new long[sl][2];

        dp[0][0] = sequence[0];
        dp[0][1] = -sequence[0];

        for(int i=1; i<sl; i++) {
            dp[i][0] = Math.max(dp[i-1][1], 0) + sequence[i];
            dp[i][1] = Math.max(dp[i-1][0], 0) - sequence[i];
        }

        for(long[] col : dp)
            answer = Math.max(answer, Math.max(col[0], col[1]));


        return answer;
    }
}