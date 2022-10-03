class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        for(int item : numbers){
            answer += item;
        }
        answer /=numbers.length;
        return answer;
    }
}