import java.util.*;
// n더하거나 2곱하거나 3곱해서 최소
class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y+1];
        
        for(int i = x; i <= y; i++){
            if(i!=x && dp[i] == 0){
                dp[i] = -1;
                continue;
            }
            
            // x에 n을 더한 값
            if(i+n <= y){
                dp[i+n] = (dp[i+n] == 0) ? dp[i]+1 : Math.min(dp[i] + 1, dp[i+n]);
            }
            if(i*2 <= y){
                dp[i*2] = (dp[i*2] == 0) ? dp[i]+1 : Math.min(dp[i] +1, dp[i*2]);
            }
            if(i*3 <= y){
                dp[i*3] = (dp[i*3] == 0) ? dp[i]+1 : Math.min(dp[i] + 1, dp[i*3]);
            }
        }
        return dp[y];
    }
}