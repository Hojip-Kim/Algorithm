
import java.util.ArrayList;
import java.util.Collections;


class Solution {
    public long solution(long n) {
        long answer = 0;
        long k = 0;
        String a = Long.toString(n);

        k = a.length();

        ArrayList<Character> list = new ArrayList<Character>();

        for(int i =0; i<k; i++){
        list.add(a.charAt(i));}

        list.sort(Collections.reverseOrder());

        String b = "";
        for(int j = 0; j<k; j++) {
            b += list.get(j);
        }

        answer = Long.parseLong(b);


        return answer;
    }

}