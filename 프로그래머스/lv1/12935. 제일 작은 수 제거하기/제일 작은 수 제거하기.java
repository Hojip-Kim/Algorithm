import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr) {
        int[] arr2 = new int[arr.length-1];
        ArrayList<Integer> arr3 = new ArrayList();
        if(arr2.length == 0){
            arr2 = new int[1];
            arr2[0] = -1;
        }
        else{
       for(int item : arr){
           arr3.add(item);
       }
       arr3.remove(Integer.valueOf(Collections.min(arr3)));

        for (int i = 0; i < arr3.size(); i++) {
            arr2[i] = arr3.get(i);
        }
        }


        return arr2;
    }
}