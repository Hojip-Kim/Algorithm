import java.util.Stack;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {};
        Stack a = new Stack();

        for(int num : num_list){
            a.add(num);
        }
        int size = a.size();
        answer = new int[size];

        
        for (int i = 0; i < size; i++) {
            answer[i] = (int) a.pop();
        }
        

        return answer;
    }
}