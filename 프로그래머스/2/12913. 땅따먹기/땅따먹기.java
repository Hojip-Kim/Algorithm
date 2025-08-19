import java.util.*;

class Solution {
    
    private static int[][] dp;
    
    int solution(int[][] land) {
        int answer = 0;
        
        dp = land; // in-place 업데이트
        
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                int up = i - 1;

                if (0 <= up) {
                    int bestUp = 0;
                    for (int k = 0; k < land[up].length; k++) {
                        if (k == j) continue;               
                        bestUp = Math.max(bestUp, dp[up][k]);
                    }
                    dp[i][j] += bestUp;
                }
            }
        }
        
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[dp.length-1][i]);
        }

        return answer;
    }
}
