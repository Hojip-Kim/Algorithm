import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] array) {
        int[] answer = {};

        ArrayList<Integer> arr = new ArrayList<>();
        for(int a : array){
            arr.add(a);
        }

        int a = arr.indexOf(Collections.max(arr));
       
        answer = new int[2];
        answer[0] = Collections.max(arr);
        answer[1] = a;
       


        return answer;
    }
}