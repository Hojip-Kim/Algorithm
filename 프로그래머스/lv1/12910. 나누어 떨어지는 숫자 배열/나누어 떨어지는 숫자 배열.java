
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int cnt = 0;
        ArrayList<Integer> arr2 = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            if(arr[i] % divisor == 0){
                arr2.add(arr[i]);
                cnt++;
            }
        }
        Collections.sort(arr2);

        if(cnt != 0){
            answer = new int[arr2.size()];
            for (int j = 0; j < arr2.size(); j++) {
                answer[j] = arr2.get(j);
            }
        }else{
            answer = new int[1];
            answer[0] = -1;
        }

        return answer;
    }
}