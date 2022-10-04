import java.util.Arrays;

class Solution {
    public int[] solution(String my_string) {
        int[] answer = {};
        String my_string_suv = "";

        for (int i = 0; i < my_string.length(); i++) {
            if((int)my_string.charAt(i) <58){
            my_string_suv += my_string.charAt(i);
            }
        }

        answer = new int[my_string_suv.length()];
        for (int i = 0; i < my_string_suv.length(); i++) {
            answer[i] = Integer.parseInt(String.valueOf(my_string_suv.charAt(i)));
        }
        Arrays.sort(answer);
        

        return answer;
    }
}