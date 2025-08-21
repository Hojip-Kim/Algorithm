import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        int maxH_Index = -1;
        
        int h_index = 0;
        
        while(h_index <= citations.length) {
            int big = 0;
            int small = 0;
            for(int citation : citations) {
                if(citation >= h_index) {
                    big++;
                }else if(citation <= h_index) {
                    small++;
                }
                
                if(big >= h_index && small <= h_index) {
                    maxH_Index = Math.max(maxH_Index, h_index);
                }
            }
            h_index++;
        }
        answer = maxH_Index;
        return answer;
    }
}