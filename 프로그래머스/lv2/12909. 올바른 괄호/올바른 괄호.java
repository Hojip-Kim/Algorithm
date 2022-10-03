import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack a = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(0) == ')' || s.charAt(s.length()-1) == '('){
                return false;
            }
            if(s.charAt(i) == '('){
                a.push(1);
            }else {
                if(a.size() == 0){
                    return false;
                }else{a.pop();}}
        }
        if(a.size() == 0){
            return true;
        }else{return false;}
        
    }
}