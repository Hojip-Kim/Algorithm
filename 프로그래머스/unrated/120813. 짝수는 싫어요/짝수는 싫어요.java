import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(i%2 == 1){
                arr.add(i);
            }
        }
        answer = new int[arr.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr.get(i);
        }

        return answer;
    }
}