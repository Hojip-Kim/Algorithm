import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String answer = "";

        ArrayList arr = new ArrayList();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 32){
                continue;
            }else {
                arr.add(Integer.parseInt(String.valueOf(s.charAt(i))));
            }
        }

        Collections.sort(arr);

        answer = String.valueOf(arr.get(0)) + " " +String.valueOf(arr.get(arr.size()-1));

        
        return answer;
    }
}