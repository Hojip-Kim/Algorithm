import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> leftHashMap = new HashMap<>();
        Map<Integer, Integer> rightHashMap = new HashMap<>();
        
        leftHashMap.put(topping[0], 1);
        
        for(int i = 1; i < topping.length; i++){
            rightHashMap.put(topping[i], rightHashMap.getOrDefault(topping[i], 0) + 1);
        }
        
        if(rightHashMap.size() == leftHashMap.size()){
            answer++;
        }
        
        for(int i = 1; i < topping.length; i++){
            leftHashMap.put(topping[i], leftHashMap.getOrDefault(topping[i], 0) + 1);
            if(rightHashMap.get(topping[i]) == 1){
                rightHashMap.remove(topping[i]);
            }else {
                int value = rightHashMap.get(topping[i]);
                value--;
                rightHashMap.put(topping[i], value);
            }
            if(rightHashMap.size() == leftHashMap.size()){
            answer++;
        }
        }
        
        
        return answer;
    }
}