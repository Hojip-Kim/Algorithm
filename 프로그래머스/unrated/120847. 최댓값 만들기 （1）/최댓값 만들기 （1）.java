import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;

        
        Integer[] arr = new Integer[numbers.length];
        for(int i =0; i<numbers.length; i++){
            arr[i] = numbers[i];
        }
       Arrays.sort(arr,Collections.reverseOrder());

       answer = arr[0]*arr[1];
        return answer;
    }
}