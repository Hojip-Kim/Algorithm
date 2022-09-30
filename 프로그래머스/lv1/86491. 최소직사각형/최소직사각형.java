import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        ArrayList<Integer> arr1 = new ArrayList();
        ArrayList<Integer> arr2 = new ArrayList();
        for (int i = 0; i < sizes.length; i++) {
            for (int j = 0; j < sizes[i].length-1; j++)
            {
                int tmp = 0;
                if(sizes[i][j] < sizes[i][j+1]){
                    tmp = sizes[i][j];
                    sizes[i][j] = sizes[i][j+1];
                    sizes[i][j+1] = tmp;
                }
                arr1.add(sizes[i][0]);
                arr2.add(sizes[i][1]);
            }
        }
        answer = Collections.max(arr1) * Collections.max(arr2);


        return answer;
    }
}