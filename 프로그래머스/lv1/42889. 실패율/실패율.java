import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        ArrayList<Double> arr = new ArrayList();
        double[] arr2 = {};
        int num = stages.length;

        for(int i = 1; i<=N; i++){
            int cnt = 0;
            for(int j = 0; j<stages.length; j++){
                if(i == stages[j]){
                    cnt++;
                }
            }
            arr.add((double)cnt/num);
            num -= cnt;
            if(num == 0){
                num = 1;
            }
        }

        arr2 = new double[arr.size()];
        for(int i= 0; i<arr.size(); i++){
            arr2[i] = arr.get(i);
        }
        Collections.sort(arr , Collections.reverseOrder());

        answer = new int[N];
        for(int i = 0; i<arr.size(); i++){
            for (int j = 0; j < arr2.length; j++) {
                if(arr.get(i) == arr2[j]){
                    answer[i] = j+1;
                    arr2[j] = 2;
                    break;
                }
            }
            }

        for(int item : answer){
            System.out.print(item + " ");
        }

        return answer;
    }
}