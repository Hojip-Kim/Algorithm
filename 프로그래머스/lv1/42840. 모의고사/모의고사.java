import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        ArrayList<Integer> arr1 = new ArrayList<>();
        int[] arr1_suv = {1, 2, 3, 4, 5};
        int cnt1 = 0;
        ArrayList<Integer> arr2 = new ArrayList<>();
        int[] arr2_suv = {2, 1, 2, 3, 2, 4, 2, 5};
        int cnt2 = 0;
        ArrayList<Integer> arr3 = new ArrayList<>();
        int[] arr3_suv = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cnt3 = 0;


        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == arr1_suv[i%5]){
                cnt1++;
            }
        }
        for (int i = 0; i < answers.length; i++) {

            if(answers[i] == arr2_suv[i%8]){
                cnt2++;
            }
        }
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == arr3_suv[i%10]){
                cnt3++;
            }
        }

        int max = Math.max(Math.max(cnt1, cnt2), cnt3);

        ArrayList<Integer> arr = new ArrayList<>();

        if(max == cnt1){
            arr.add(1);
        }
        if(max == cnt2){
            arr.add(2);
        }
        if(max == cnt3){
            arr.add(3);
        }

        answer = new int[arr.size()];
        for(int i = 0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }

        return answer;
    }
}