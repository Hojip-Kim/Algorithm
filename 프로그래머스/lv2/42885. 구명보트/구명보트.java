import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i : people){
            arr.add(i);
        }
        Collections.sort(arr, Collections.reverseOrder());

        int tmp = 0;
        int people_num = arr.size();
        for (int i = 0; i < people_num; i++) {
        if(arr.get(i) + arr.get(people_num-1) <= limit){
            answer++;
            people_num--;
        }else{
            answer++;
        }

        }


//80 70 50 50
//80 70 50
        // 80 70 60 55 50 20 10
        return answer;
    }
}