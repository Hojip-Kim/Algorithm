import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String answer = "";

        String[] arr = s.split(" ");

        ArrayList<Integer> arr2 = new ArrayList();

        for (int i = 0; i < arr.length; i++) {
            arr2.add(Integer.parseInt(arr[i]));
        }
        Collections.sort(arr2);

        answer = String.valueOf(arr2.get(0)) + " " + String.valueOf(arr2.get(arr2.size()-1));

        return answer;
    }
}