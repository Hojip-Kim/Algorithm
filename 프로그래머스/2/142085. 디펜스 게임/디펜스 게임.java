import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        if(k >= enemy.length){
            return enemy.length;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int elem : enemy){
            if(k > 0){
                k--;
                pq.offer(elem);
            }else{
                int num = pq.poll();
                if(num < elem){
                    pq.offer(elem);
                    n-=num;
                }else{
                    n-=elem;
                    pq.offer(num);
                }
                if(n < 0){
                    break;   
                }
            }
            answer++;            
        }
        
        return answer;
    }
}