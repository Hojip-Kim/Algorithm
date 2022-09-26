

import java.util.*;

public class Solution {
    public int[] solution(int []arr) { // {1, 1, 1, 3, 3, 0, 1, 1}
        int[] answer = {};

        LinkedList<Integer> arr2 = new LinkedList<>();

        int i = 0;
        int cnt = 0;
        arr2.add(arr[0]);
        while(true){

            if(arr[i] != arr[i+1] && arr2.get(cnt) != arr[i+1]) {
                arr2.add(arr[i+1]);
                cnt++;
            }
            i++;
            if(i == arr.length-1){
                break;
            }
        }
        int len = arr2.size();
        answer = new int[len];

        for(int j = 0; j<len; j++){
            answer[j] = arr2.getFirst();
            arr2.removeFirst();
        }

        return answer;
    }
}
