import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int answer = 0;
        boolean isFound = false;
        
        for(int elem : scoville){
            pq.add((long)elem);
        }
        
        if (!pq.isEmpty() && pq.peek() >= K) return 0;
        
        while(!pq.isEmpty()) {
            
            if(pq.size() > 1 && pq.peek() < K){
                long lowestScoville = pq.poll();
                long secondLowestScoville = pq.poll();
                long newestScoville = lowestScoville + secondLowestScoville * 2;
                pq.add(newestScoville);
                answer++;
            }else {
                break;
            }
            
            if(pq.peek() >= K){
                isFound = true;
                break;
            }
        }
        if(isFound){
            return answer;
        }else {
            return -1;
        }
        
    }
}