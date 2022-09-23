

import java.util.ArrayList;

class Solution {
    public String solution(String s) {
        String answer = "";



        int cnt = 0;
        cnt = (int)s.length()/2;

        if(s.length() % 2 == 0){
            answer = String.valueOf(s.charAt(cnt-1)) + String.valueOf(s.charAt(cnt));
        }else {answer = String.valueOf((s.charAt(cnt)));}

        return answer;
    }
}