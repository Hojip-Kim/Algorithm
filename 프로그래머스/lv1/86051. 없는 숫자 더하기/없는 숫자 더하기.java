

import java.util.ArrayList;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;

        ArrayList<Integer> arr = new ArrayList<>();

        for(int item : numbers){
            arr.add(item);
        }
        for(int i = 0; i<10; i++){
            if(arr.contains(i)){
                continue;
            }else{
                answer += i;
            }
        }

        return answer;
    }
}