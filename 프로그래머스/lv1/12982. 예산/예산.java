import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] d, int budget) { // 3 4 2 , 7 / 2, 2, 2, 2 , 8
        Queue queue = new LinkedList();
        int cnt = 0;
        int add_Num = 0;
        int answer = 0;
        Arrays.sort(d); // 2 3 4

        for(int item : d){
            queue.add(item);
            add_Num += (int)queue.poll();
            if(add_Num > budget){
                break;
            }
            cnt++;
        }
        answer = cnt;


        return answer;
    }
}