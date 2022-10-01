import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack stack = new Stack();
        String[] arr = s.split(" ");

        for(String item : arr){
            if(!item.equals("Z")){
            stack.push(item);}
            else{
                stack.pop();
            }
        }
        int num = stack.size();
        for (int i = 0; i < num; i++) {
            answer += Integer.parseInt((String) stack.pop());
        }

        return answer;
    }
}