import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public Object[] solution(int[] numbers) {
        Object[] answer = {};
        HashSet hash = new HashSet();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                hash.add(numbers[j]+numbers[i]);
            }
        }
        answer = hash.toArray();
        Arrays.sort(answer);

      
        return answer;
    }
}