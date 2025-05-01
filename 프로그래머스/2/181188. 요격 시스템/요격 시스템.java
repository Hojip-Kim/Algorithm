import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
       Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        
        
        int beforeIdx = 0;
        for(int i = 0; i < targets.length; i++){
            if(beforeIdx <= targets[i][0]){
                beforeIdx = targets[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}