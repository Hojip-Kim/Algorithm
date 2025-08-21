import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            String rotated = s.substring(i) + s.substring(0, i); // i만큼 회전
            if (isValid(rotated)) answer++;
        }
        
        return answer;
    }
    
    private boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
