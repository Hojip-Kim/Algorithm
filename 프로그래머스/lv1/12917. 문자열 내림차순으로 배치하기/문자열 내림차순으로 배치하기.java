
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String answer = "";

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();



        for(int i = 0; i<s.length(); i++){
            int a = s.charAt(i);
            if(a > 96 && a < 123){
            arr1.add(a);
            }
            }
        Collections.sort(arr1, Collections.reverseOrder());

        for(int j = 0; j<s.length(); j++){
            int b = s.charAt(j);
            if(b<91){
                arr2.add(b);
            }
        }
        Collections.sort(arr2, Collections.reverseOrder());

        arr1.addAll(arr2);

        for(int i = 0; i<arr1.size(); i++){
            char a;
            a = (char)((int)(arr1.get(i)));

            answer += a;
        }
        System.out.println(answer);
        return answer;
    }
}