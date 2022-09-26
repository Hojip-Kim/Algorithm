


import java.lang.reflect.Array;
import java.util.ArrayList;

class Solution {
    public String solution(String s){
        String answer = "";

        String[] arr = s.split("");



        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i].equals(" "))) {
                cnt = 0;
            } else {
                if (cnt % 2 == 0) {
                    arr[i] = arr[i].toUpperCase();
                    cnt++;
                } else {
                    arr[i] = arr[i].toLowerCase();
                    cnt++;
                }


            }
            answer += arr[i];
        }


        return answer;
    }
}