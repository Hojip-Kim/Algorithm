
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        int tmp_Idx = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int cnt = 0;

            for (int j = tmp_Idx; j < progresses.length; j++) { // 93,30,55 / 1,30,5 => 2, 1
                progresses[j] += speeds[j];
            }

            for (int j = tmp_Idx; j < progresses.length; j++) {
                if(progresses[j] >= 100){
                    cnt++;
                    tmp_Idx++;
                }else{
                    break;
                }
            }
            if(cnt > 0){
            queue.offer(cnt);}
            else{
                continue;
            }
            if(tmp_Idx == progresses.length){
                break;
            }
        }

        int tmp=queue.size();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < tmp; i++) {
            arr.add(queue.poll());
        }
        answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        
        return answer;
        }

    }
