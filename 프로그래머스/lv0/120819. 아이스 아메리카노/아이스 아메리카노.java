class Solution {
    public int[] solution(int money) {
        int[] answer = {};

        answer = new int[2];
        
        int a = (int)(money/5500);
        
        int b = money%5500;
        
        answer[0] = a;
        answer[1] = b;

        return answer;
    }
}