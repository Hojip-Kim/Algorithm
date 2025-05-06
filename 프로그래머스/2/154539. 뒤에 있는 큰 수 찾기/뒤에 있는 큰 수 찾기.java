import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        // stack 사용
        Stack<Integer> stack = new Stack<Integer>();
        
        Arrays.fill(answer,-1);
        
        for(int i = numbers.length-1; i >= 0; i--){
            
            while(!stack.isEmpty() && numbers[i] >= stack.peek()){
                stack.pop();
            }
            
            if(!stack.isEmpty()){
                answer[i] = stack.peek();
            }
            
            stack.push(numbers[i]);
            
        }
        
        return answer;
    }
}