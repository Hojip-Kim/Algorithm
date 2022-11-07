class Solution {
    public int[] solution(int num, int total) {
        int[] answer = {};
        int total_suv = 0;
        answer = new int[num];

        for (int i = 0; i < num; i++) {
            total_suv += i;
        }
        int i = (total-total_suv) / num;
        
        answer = new int[num];

        for (int j = 0; j < num; j++) {
            answer[j] = i+j;
        }
        
        return answer;
    }
}