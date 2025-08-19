import java.util.*;

class Solution {
    private static Map<String, Integer> map;
    private static int[] slidingWindow;
    private static int answer;
    public int solution(String[] want, int[] number, String[] discount) {
        answer = 0;
        map = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], i);
        }
        
        slidingWindow = firstScanDiscount(want, number, discount);
        
        for(int i = 10; i < discount.length; i++){
            int curLeft = i-10;
            int nextRight = i;
            if(map.containsKey(discount[curLeft])){
            slidingWindow[map.get(discount[curLeft])]--;
            }
            if(map.containsKey(discount[nextRight])){
            slidingWindow[map.get(discount[nextRight])]++;
            }
            if(isValidArr(number, slidingWindow)){
                answer++;
            }
        }
        
        return answer;
    }
    
    private int[] firstScanDiscount(String[] want, int[] number, String[] discount) {
        int[] arr = new int[number.length];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < want.length; j++){
                if(discount[i].equals(want[j])) {
                    arr[j]++;
                }
            }
        }
        
        if(isValidArr(number, arr)){
            answer++;
        }
        
        return arr;
    }
    
    private boolean isValidArr(int[] arr1, int[] arr2){
        boolean isValid = true;
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] > arr2[i]){
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}