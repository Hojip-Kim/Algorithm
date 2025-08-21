import java.util.*;

class Solution {
    
    private static Stack<Integer> stack = new Stack<>();
    
    public int solution(int[] order) {
        
        int answer = 0;
        
        int[] boxArr = new int[order.length];
        
        for (int i = 1; i <= boxArr.length; i++){
            boxArr[i - 1] = i;
        }

        int belt = 0;
        int index = 0;

        while (index < order.length) {
            if (!stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop();
                answer++;
                index++;
                continue;
            }

            if (belt < boxArr.length) {
                int cur = boxArr[belt];
                if (cur == order[index]) {
                    answer++;
                    index++;
                } else {
                    stack.push(cur);
                }
                belt++;
            } else {
                break;
            }
        }
        return answer;
    }
}