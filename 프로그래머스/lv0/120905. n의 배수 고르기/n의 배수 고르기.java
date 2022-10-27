import java.util.ArrayList;

class Solution {
    public int[] solution(int n, int[] numlist) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < numlist.length; i++) {
            if(numlist[i] % n == 0){
                arr.add(numlist[i]);
            }
        }
        
        answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }

        return answer;
    }
}