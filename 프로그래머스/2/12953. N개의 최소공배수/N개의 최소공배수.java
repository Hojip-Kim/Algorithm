import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = -1;
        int cnt = 1;
        boolean isCorrect = true;
        while(true) {
            for(int elem : arr) {
                if (cnt % elem != 0){
                    isCorrect = false;
                    break;
                }
            }
            if(!isCorrect) {
                cnt++;
            }else {
                answer = cnt;
                break;
            }
            isCorrect = true;
            
        }
        return answer;
    }
}